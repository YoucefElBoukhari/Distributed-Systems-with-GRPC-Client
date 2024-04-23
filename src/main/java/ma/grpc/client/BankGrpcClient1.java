package ma.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ma.grpc.stubs.Bank;
import ma.grpc.stubs.BankServiceGrpc;

public class BankGrpcClient1 {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",5555)
                .usePlaintext() //Le model de négociation entre le client et le serveur
                .build();
        BankServiceGrpc.BankServiceBlockingStub blockingStub= BankServiceGrpc.newBlockingStub(managedChannel);
        Bank.ConvertCurrencyRequest request= Bank.ConvertCurrencyRequest.newBuilder()
                .setCurrencyFrom("MAD")
                .setCurrencyTo("USD")
                .setAmount(6900)
                .build();
        Bank.ConvertCurrencyResponse currencyResponse = blockingStub.convert(request);
        System.out.println(currencyResponse);
    }
}
