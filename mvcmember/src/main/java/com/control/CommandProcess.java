package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
  public String requestPro(HttpServletRequest request, HttpServletResponse response)
      throws Throwable;
  // jsp파일명 리턴해줄거다
}
