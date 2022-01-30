package System_Design.Object_oriented;

class JobScheduler{

    PriorityQueue<Job> pQueue;

    JobScheduler(){
        this.pQueue = new PriorityQueue<>((x, y)->{
           if(x.user > y.user) return -1;
           else if(x.user){
               return x.priority - y.priority;
           }
           else return 1;
        });
    }
}

class Job{
    long id;
    String name;
    int priority;
    User user;
    LocalDateTime deadline;
    long duration;

    Job(){

    }
}

public enum User{
    Root, Admin, User; // have priorities, so define in order
}

enum SchedulingAlgorithm{
    FCFS, JF, LJF, EDF; // earliest deadline first 
}