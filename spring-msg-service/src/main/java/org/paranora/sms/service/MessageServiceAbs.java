package org.paranora.sms.service;

import org.paranora.sms.entity.Message;

public abstract class MessageServiceAbs<T extends Message> implements MessageService<T> {

    protected MessageSender sender;
    protected MessageFetcher fetcher;
    protected MessageConverter converter;

    public MessageServiceAbs(){
        init();;
    }

    protected void init(){
        defaultSender();
        defaultFetcher();
        defaultConverter();
    }

    public void defaultSender() {
    }

    public void defaultFetcher() {
    }

    public void defaultConverter(){
    }

    public void defaultSender(MessageSender sender) {
        this.sender = sender;
    }

    public void defaultFetcher(MessageFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public void defaultConverter(MessageConverter converter){
        this.converter=converter;
    }

    public MessageSender getSender() {
        return sender;
    }

    public MessageFetcher getFetcher() {
        return fetcher;
    }

    public MessageConverter getConverter() {
        return converter;
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
    public void fetch(T message) {
        fetcher.fetch(message);
    }

    @Override
    public void fetch(String message) {
        fetcher.fetch(converter.from(message));
    }

    @Override
    public void fetch(byte[] message) {
        fetcher.fetch(converter.from(message));
    }
}
