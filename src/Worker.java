public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    private OnTaskDoneListener callback;

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
            if (i == 33) {
                errorCallback.onError("Task " + i + " catch Error!");
                return;
            }
        }
    }
}
