# CustomSocketFactory

## Description
`CustomSocketFactory` is a custom implementation of `SocketFactory` that allows configuring Keep-Alive parameters for Java sockets. It supports extended `ExtendedSocketOptions` for TCP connections, such as `TCP_KEEPIDLE`, `TCP_KEEPINTERVAL`, and `TCP_KEEPCOUNT`.

## Features
- Configurable Keep-Alive parameters via `Properties`.
- Support for extended TCP Keep-Alive options (if supported by the system).
- Safe handling of invalid parameter values.

## Usage

### Adding to a Maven Project
This project is managed using Maven. To use this class in your project, simply add it to your Java code and compile it using Maven.

### Example Usage
```java
import java.util.Properties;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("keepAlive", "true");
        props.setProperty("keepAliveIdle", "10");
        props.setProperty("keepAliveInterval", "5");
        props.setProperty("keepAliveCount", "3");

        CustomSocketFactory factory = new CustomSocketFactory(props);
        try {
            Socket socket = factory.createSocket();
            System.out.println("Socket created with Keep-Alive settings.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Requirements
- Java 11+
- Support for `ExtendedSocketOptions` in the operating system (for additional Keep-Alive options)

## Build and Test
Build using Maven:
```sh
mvn clean install
```
