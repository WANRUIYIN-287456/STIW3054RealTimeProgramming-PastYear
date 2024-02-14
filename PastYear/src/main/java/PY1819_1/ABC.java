package PY1819_1;
/*
18_19_1 Q7
 */
//Is the following implementation thread-safe? Justify your answer by providing two reasons.
public class ABC{
    private ABC instance = null;
    public ABC getInstance(){
        if (instance == null){
            synchronized (ABC.class){
                if(instance == null){
                    instance = new ABC();
                }
            }
        }
        return instance;
    }
}

/*

Not thread safe
1. Race Condition During Initialization:
Multiple threads may simultaneously pass the initial null check if (instance == null) and proceed to acquire the class-level lock (synchronized (ABC.class)). However, only one thread will successfully create the singleton instance, while the other threads may create redundant instances of ABC, violating the singleton pattern.
2. Potential Visibility Issues:
Without proper synchronization or the use of volatile variables, changes made to shared variables by one thread may not be immediately visible to other threads. As a result, other threads may still observe a partially initialized or stale instance of the singleton object, leading to incorrect behavior or unexpected errors.

 */