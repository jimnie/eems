package com.workshop.eems.service.impl;

import com.workshop.eems.Message;
import com.workshop.eems.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * Created by Wayne on 2015/6/1.
 */
@Service("messageServiceImpl")
public class MessageServiceImpl extends BaseServiceImpl<Message, Long> implements MessageService {

}
