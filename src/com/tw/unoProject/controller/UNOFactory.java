package com.tw.unoProject.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UNOFactory {
    public ServerSocket createServerSocket() {
        try {
            return new ServerSocket(9090);
        } catch (IOException e) {
            throw new RuntimeException("Unable to start the server", e);
        }
    }

    public Client acceptClient(ServerSocket serverSocket) {
        try {
            Socket socket = serverSocket.accept();
            return new Client(socket);
        } catch (IOException e) {
            throw new RuntimeException("not able to accept the client");
        }
    }

    public Socket createClientSocket(String serverAddress) {
        try {
            return new Socket(serverAddress, 9090);
        } catch (IOException e) {
            throw new RuntimeException("could not connect to " + serverAddress + " at " + 9090, e);
        }
    }
}