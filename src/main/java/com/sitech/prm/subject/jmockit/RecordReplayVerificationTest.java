package com.sitech.prm.subject.jmockit;

import mockit.Injectable;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
/** 
 * 一个完整的Mock会有三个步骤，步骤一、record （录制）；步骤二、replay 在此阶段，录制的方法可能会被调用；步骤三、验证。如果是Expectations就没有必要做Verifications了。 
 * @author Ginge 
 * 
 */  
@RunWith(JMockit.class)
public class RecordReplayVerificationTest {  
  
	@Injectable    WinportUrlServiceImpl winportUrlService;  
	
	
  
    @Tested
    OfferPostAction offerPostAction;  
  
    @Test  
    public void testofferPostActionExecute(  ) {  
        final String memberId = "test2009";  
        // 步骤一、record （录制）  
        new NonStrictExpectations() {  
            {  
                // 期望被mock的调用，以及被调用时返回的结果  
                winportUrlService.hasWinport(memberId);  
                result = false; // 也可以是returns(false);  
                // 总共可以调用的次数  
                times = 1;  
            }  
        };  
  
        // 步骤二、replay 在此阶段，录制的方法可能会被调用  
        Assert.assertEquals(false, offerPostAction.hasWinport(memberId));  
          
        try{  
            offerPostAction.getWinportUrlThrowException(memberId);  
        }catch(Exception e){  
            //fully mock，默认完全被mock，到这里就注定失败  
            Assert.fail();  
        }  
          
          
  
        // 步骤三、验证步骤二中，mock方法是否被调用，本步骤可以省略  
        new Verifications() {  
            {  
                winportUrlService.hasWinport(withAny(""));  
                times = 1;  
            }  
        };  
    }  
    
    @Test
    public void test() {
    	final String memberId = "test2009";  
    	new NonStrictExpectations() {  
            {  
                // 期望被mock的调用，以及被调用时返回的结果  
                winportUrlService.getPostedOfferCounts(memberId);  
                result = 2000L; // 也可以是returns(false);  
                // 总共可以调用的次数  
                times = 1;  
            }  
        };
        
        long rtn = offerPostAction.getPostedOfferCounts(winportUrlService,memberId);  
        
        Assert.assertEquals(2000L, rtn);  
    }
    
    @Test
    public void testPrivate() {
    	final String memberId = "test2009";  
    	new NonStrictExpectations() {  
            {  
                // 期望被mock的调用，以及被调用时返回的结果  
                winportUrlService.getPostedOfferCounts(memberId);  
                result = 2000L; // 也可以是returns(false);  
                // 总共可以调用的次数  
                times = 1;  
            }  
        };
        
        long rtn = offerPostAction.privateMethod(winportUrlService,memberId);  
        
        Assert.assertEquals(2000L, rtn);  
    }
}  