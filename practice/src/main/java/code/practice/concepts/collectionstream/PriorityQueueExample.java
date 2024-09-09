package code.practice.concepts.collectionstream;

import java.util.Comparator;
import java.util.PriorityQueue;

class Job{
    String jobName;
    int priority;

    //String description

    public Job(String jobName, int priority) {
        this.jobName = jobName;
        this.priority = priority;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(30);
        pq.add(10);
        pq.add(5);
        pq.add(15);
        System.out.println(pq.peek());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        PriorityQueue<Job> jobPriority = new PriorityQueue<>(Comparator.comparing(Job::getPriority).reversed().thenComparing(Job::getJobName));
        jobPriority.add(new Job("first",1));
        jobPriority.add(new Job("high",5));
        jobPriority.add(new Job("asecond High",5));
        jobPriority.add(new Job("third",3));
        jobPriority.add(new Job("fourth",4));

        System.out.println(jobPriority.peek().getJobName());

        while(!jobPriority.isEmpty()){
            Job job = jobPriority.poll();
            System.out.println(job.getJobName() +" with priority of "+job.getPriority());
        }

    }
}
