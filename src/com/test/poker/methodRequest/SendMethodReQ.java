package com.test.poker.methodRequest;

import com.test.poker.regular.Player;
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
		Type outType = (TypeValidation.validate(sender.getOutlist()));
		sender.setOutType(outType);
	}
	/* (non-Javadoc)
	 * @see com.test.poker.methodRequest.ISendMethodReQ#beforeSend()
	 */
	
	public boolean beforeSend(Player reciever) throws Exception{
		if(sender.getOutType()==null){
			throw new Exception(sender.getPlayerName()+" 不合法出牌"+sender.getOutType());
		}
		
		if(!canSend(reciever)){
			return false;
		}
		return true;
	}
	private boolean canSend(Player reciever) {
		boolean result = false;
		if(sender.getInType() == null){
			result =  true;
		}else{	//接牌
			TypeWrapper wrapper = new TypeWrapper(sender.getOutType());
			if(wrapper.biggerThan(sender.getInType())){
				result =  true;
			}else{
				System.err.println(sender.getPlayerName()+" 不合法出牌："+sender.getOutType());
				result = false;
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.test.poker.methodRequest.ISendMethodReQ#afterSend()
	 */
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
		reciever.revieve(sender.getOutType());
		afterSend();
		return true;
	}
}
