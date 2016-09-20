package com.sitech.prm.subject.jmockit;

public interface WinportUrlService {  
    boolean hasWinport(String memberId);  
  
    String getWinportUrlThrowException(String memberId);  
} 