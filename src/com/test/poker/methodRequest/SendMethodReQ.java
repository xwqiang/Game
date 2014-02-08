package com.test.poker.methodRequest;

import com.test.poker.regular.Player;
import com.test.poker.type.AffordNone;
import com.test.poker.type.Type;
import com.test.poker.type.TypeWrapper;
import com.test.poker.type.exception.IllegalTypeException;
import com.test.poker.validate.TypeValidation;

/**
 * 出牌方法
 * @author 1207264
 *
 */
public class SendMethodReQ implements ISendMethodReQ{
	private Player sender;
	public SendMethodReQ(Player sender){
		this.sender = sender;
		//构造outType
		Type outType = (TypeValidation.validate(sender));
		sender.setOutType(outType);
	}
	
	public boolean beforeSend(Player reciever){
		return true;
	}

	
	
	public boolean afterSend(){
		sender.getOutlist().clear();
		sender.getPokerDealer().confirmSending();
		return true;
	}
	
	
	public boolean send(Player reciever) throws IllegalTypeException{
		if(!beforeSend(reciever)){return false;}
		
		TypeWrapper wrapper = new TypeWrapper(sender.getOutType());
		if(sender.getInType()==null){sender.setInType(new AffordNone(sender));}
		if(wrapper.biggerThan(sender.getInType())){
			System.out.println(sender.getPlayerName()+" 出牌："+sender.getOutType());
			reciever.revieve(sender.getOutType());
			afterSend();
			return true;
		}else{
			if(sender.getOutType() instanceof AffordNone){
				System.out.println(sender.getPlayerName()+" : 放弃出牌");
			}else{
				System.out.println(sender.getPlayerName()+" : 牌太小或无法比较");
			}
			reciever.revieve(sender.getInType());
			sender.getOutlist().clear();
			sender.getPokerDealer().cancelSending();
			return false;
		}
	}
}
