package com.fordTest1.DesignPatterns.creational.builder;

public class URLBuilder {

    private String protocol;
    private String host;

    //Optional Parameters
    private String port;
    private String path;
    private String query;

    private URLBuilder(Builder builder) {
        this.protocol = builder.protocol;
        this.host = builder.host;
        this.port = builder.port;
        this.path = builder.path;
        this.query = builder.query;
    }

    @Override
    public String toString() {
        StringBuilder url = new StringBuilder();
        url.append(protocol).append("://").append(host);
        if (port != null && !port.isEmpty()) {
            url.append(":").append(port);
        }
        if (path != null && !path.isEmpty()) {
            url.append("/").append(path);
        }
        if (query != null && !query.isEmpty()) {
            url.append("?").append(query);
        }
        return url.toString();
    }

    // Static method to create a builder
    public static Builder builder(String protocol, String host) {
        return new Builder(protocol, host);
    }

    public static class Builder{

        private String protocol;
        private String host;

        //Optional Parameters
        private String port;
        private String path;
        private String query;

        public Builder(String protocol,String host){
            this.protocol = protocol;
            this.host = host;
        }



        public Builder port(String port){
            this.port = port;
            return this;
        }
        public Builder path(String path){
            this.path = path;
            return this;
        }

        public Builder query(String query){
            this.query = query;
            return this;
        }

        public URLBuilder build(){
            return new URLBuilder(this);
        }




    }
}
