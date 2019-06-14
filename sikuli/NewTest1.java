package sikuli;

import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class NewTest1 {
  @Test
  public void f() throws Exception {
	  Screen s = new Screen();
	  s.click("D:\\workspace\\sikuli_images.sikuli\\1560320272149.png");
	  Thread.sleep(5000);
  }
}
