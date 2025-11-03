import java.util.*;

class Solution {
    class Task {
        String name;
        int startTime;
        int takenTime;
        public Task(String name, int startTime, int takenTime) {
            this.name = name;
            this.startTime = startTime;
            this.takenTime = takenTime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;
        for (int i = 0; i < plans.length; i++) {
            String[] time = plans[i][1].split(":");
            plans[i][1] = String.valueOf(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));

        }
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });
        Deque<Task> taskQueue = new ArrayDeque();
        for (int i = 0; i < plans.length; i++) {
            taskQueue.add(new Task(plans[i][0],Integer.parseInt(plans[i][1]), Integer.parseInt(plans[i][2])));
        }

        Stack<Task> waitQueue = new Stack<>();
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            Task nextTask = taskQueue.peek();
            if (nextTask == null) {
                answer[index++] = task.name;
                break;
            }

            if (task.startTime + task.takenTime <= nextTask.startTime) { // 바로 다음 거 할 수 잇을 때
                answer[index++] = task.name;
                if (!waitQueue.isEmpty()) {
                    Task pausedTask = waitQueue.pop();
                    pausedTask.startTime = task.startTime + task.takenTime;
                    taskQueue.addFirst(pausedTask);
                }
            } else { // 잠시 멈춰야 할 때
                task.takenTime = task.takenTime - (nextTask.startTime - task.startTime);
                waitQueue.add(task);
            }
        }
        while (!waitQueue.isEmpty()) {
            Task waitedTask = waitQueue.pop();
            answer[index++] = waitedTask.name;
        }

        return answer;
    }
}