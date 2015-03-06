package com.marcubus.nio;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("session")
public class LogViewController {

  @Autowired
  private LogReader reader;
  
  @RequestMapping(value="/log", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<String> getNewEvents() throws IOException {    
    List<String> result = new LinkedList<String>();
    String line = null;
    while ((line = reader.nextEntry()) != null)
      result.add(line);
    return result;
  }
  
}
