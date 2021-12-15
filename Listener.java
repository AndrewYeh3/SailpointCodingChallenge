// A message processing component receives an unknown number of messages that are numbered from 0..N, one at a time. The value of N is unknown. 
// Delivery is reliable in the sense that all messages will eventually be received. However, the order in which they are received can be completely random. 
// All messages are to be handed off to a Processor with an interface like the following: process(List<Message> batch)
// Any number of batches can be submitted to the processor, however:
// All messages in a given batch must be in order, with no gaps
// Batches must be in the proper order, with no gaps
// For example, if the first batch of messages sent to the Processor contains messages 0..3, the next batch must start with message 4. 
// There is no minimum or maximum batch size.
// Your task is to complete a collating Listener that receives a single message, buffers it in a datastructure (of your choosing) and from time to time submits a 
// valid batch of buffered messages to the processor. Please submit the results as a link to public github or Bitbucket repository.
import java.util.*;
public class Listener{
    HashMap<Integer, Message> messages = new HashMap<Integer,Message>();
    int tracker = 0;
    public void Listener(){

    }
    //create a listener class that takes one message at a time
    //public void receive message receives a single message
    //hashset or hashmap,key is message number
    //index starting at 0,
    public void receiveMessage(Message m){
        // gets the number of the message
        int index = m.getNumMessage();
        //add the message to the hashmap
        messages.put(index,m);
        //whenever the index matches the tracker, try to submit a message
        if(index == tracker){
            submitMessages();
        }
    }

    public void submitMessages(){
        //create new batch of messages
        List<Message> batch = new ArrayList<Message>();
        //tries to add all batches starting from tracker to the list
        while(messages.get(tracker) != null){
            batch.add(messages.get(tracker));
            tracker++;
        }
        //sends the batch to process
        process(batch);
    }

    public static void main(String args[]){

    }

    public void process(List<Message>batch){
        //pseudocode
    }

    public class Message{
        int number;
        String message;
        public Message(int number, String message){
            this.number = number;
            this.message = message;
        }

        public int getNumMessage(){
            return number;
        }
    }
    
}