class MessageNotifier extends Thread {

    String str;
    int count;

    public MessageNotifier(String msg, int repeats) {
        str = msg;
        count = repeats;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
}