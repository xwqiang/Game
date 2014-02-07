package com.test.poker.methodRequest;

import com.test.poker.regular.Player;
import com.test.poker.type.AffordNone;
import com.test.poker.type.Type;
import com.test.poker.type.TypeWrapper;
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
	
	/**
	 * 校验出牌是否合法  出牌是否比上家大
	 */
	public boolean beforeSend(Player reciever) throws Exception{
		//不合法出牌
		if(sender.getOutType()==null || sender.getOutType() instanceof AffordNone){
			throw new Exception(sender.getPlayerName()+" 不合法出牌"+sender.getOutType());
		}
		//出牌太小
		if(!biggerSending(reciever)){
			return false;
		}
		return true;
	}
	private boolean biggerSending(Player reciever) {
		if(sender.getInType() == null || sender.getInType() instanceof AffordNone){
			return true;
		}else{	//接牌
			TypeWrapper wrapper = new TypeWrapper(sender.getOutType());
			if(wrapper.biggerThan(sender.getInType())){
				return true;
			}else{
				System.err.println(sender.getPlayerName()+" 不合法出牌："+sender.getOutType());
				return false;
			}
		}
	}

	
	
	public boolean afterSend(){
		sender.getOutlist().clear();
		sender.getPokerDealer().confirmSending();
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.test.poker.methodRequest.ISendMethodReQ#send(com.test.poker.regular.Player)
	 */
	public boolean send(Player reciever) throws Exception{
		beforeSend(reciever);
		System.out.println(sender.getPlayerName()+" 出牌："+sender.getOutType());
		if(sender.getOutType() instanceof AffordNone){
			reciever.revieve(sender.getInType());
		}
		reciever.revieve(sender.getOutType());
		afterSend();
		return true;
	}
}
