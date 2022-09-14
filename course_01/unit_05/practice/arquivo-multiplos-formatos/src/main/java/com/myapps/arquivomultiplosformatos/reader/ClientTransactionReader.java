package com.myapps.arquivomultiplosformatos.reader;

import com.myapps.arquivomultiplosformatos.domain.Client;
import com.myapps.arquivomultiplosformatos.domain.Transaction;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class ClientTransactionReader implements ItemStreamReader<Client>, ResourceAwareItemReaderItemStream<Client> {

    // Stores the current reading objects
    private Object currentObject;

    // This is the reader that can be used to read in fact the data from the source files
    private FlatFileItemReader<Object> delegate;

    public ClientTransactionReader(FlatFileItemReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Client read() throws Exception {
        // If there's no already read object set the currentObject
        if (currentObject == null) {
            currentObject = delegate.read(); // Reads next register
        }

        // Create new client object and reset the read one
        Client client = (Client) currentObject;
        currentObject = null;

        // If there's still data to be read and no EOF
        if (client != null) {
            // Peek will read and add each Transaction to the Client transactions when the readen data is a Transaction
            while(peek() instanceof Transaction) {
                // Now currentObject is not null anymore, since it's receiving data from peek()
                client.getTransactions().add((Transaction) currentObject);
            }
        }

        // Return the Client with it's Transactions if any
        return client;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    private Object peek() throws Exception {
        currentObject = delegate.read(); // Reads next register
        return currentObject;
    }

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }
}
