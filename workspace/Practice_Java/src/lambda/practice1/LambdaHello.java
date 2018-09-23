package lambda.practice1;

public class LambdaHello {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous class");
			}
		}).start();
		
		//위의 thread와 동일한 과정을 Lambda 형식으로 출력
		new Thread(() -> System.out.println("Lambda expression")).start();
	}
}
