package net.floodlightcontroller.notification.syslog;

import org.slf4j.Logger;

import net.floodlightcontroller.notification.INotificationManager;

public class SyslogNotificationManager implements INotificationManager {

    private final Logger logger;
    // 로그 메세지 서버로 전송하기 위한것 !!!!!!!!!!!!
    private SyslogNotificationHandler sysNotificationHandler = new SyslogNotificationHandler();
    
    public SyslogNotificationManager(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void postNotification(String notes) {
    	sysNotificationHandler.sendLogMessage(notes);
       logger.warn(notes);
    }

}
