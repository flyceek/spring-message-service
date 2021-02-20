package org.paranora.sms.service;

import org.paranora.sms.entity.Message;

public abstract class MessageServiceAbs<T extends Message> implements MessageService<T> {

    protected MessageSender sender;
    protected MessageFetcher fetcher;

    public MessageServiceAbs(){
        init();;
    }

    protected void init(){
        defaultSender();
        defaultFetcher();
    }

    public void defaultSender() {
    }

    public void defaultFetcher() {
    }


    public void defaultSender(MessageSender sender) {
        this.sender = sender;
    }

    public void defaultFetcher(MessageFetcher fetcher) {
        this.fetcher = fetcher;
    }


    @Override
    public void send(T message) {
        sender.send(message);
    }

    @Override
    public void sendSync(T message) throws Exception {
        sender.sendSync(message);
    }

    @Override
    public boolean fetch(T message) throws Exception {
        return fetcher.fetch(message);
    }

}
