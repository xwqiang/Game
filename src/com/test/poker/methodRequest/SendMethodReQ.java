package com.test.poker.methodRequest;

import com.test.poker.regular.Player;
import com.test.poker.type.TypeWrapper;

/**
 * 出牌方法
 * @author 1207264
 *
 */
public class SendMethodReQ{
	private Player sender;
	public SendMethodReQ(Player sender){
		this.sender = sender;
	}
	public boolean beforeSend(){
		return true;
	}
	public boolean afterSend(){
		return true;
	}
	
	public boolean send(Player reciever){
		// 出牌
		if(sender.getInType() == null){
			System.out.println(sender.getPlayerName()+" 出牌:"+sender.getOutType().toString());
			reciever.revieve(sender.getOutType());
			return true;
		}else{	//接牌
			System.out.println(sender.getPlayerName()+" 出牌:"+sender.getOutType().toString());
			TypeWrapper wrapper = new TypeWrapper(sender.getOutType());
			if(wrapper.biggerThan(sender.getInType())){
				reciever.revieve(sender.getOutType());
				return true;
			}else{
				reciever.revieve(null);
				return false;
			}
		}
	}
}
