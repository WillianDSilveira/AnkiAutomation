
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class MainAutomation {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();

        // Aguardar 5 segundos para preparar o ambiente
        Thread.sleep(5000);

        for (int i = 0; i < 2; i++) {
            // Copiar (Ctrl + C)
            pressCtrlC(robot);
            Thread.sleep(1000);

            // Alternar para o Anki (Alt + Tab)
            altTab(robot);
            Thread.sleep(1000);

            // Colar (Ctrl + V)
            pressCtrlV(robot);
            Thread.sleep(2000);

            // Clicar no alto-falante
            click(robot, 648, 78);
            Thread.sleep(2000);

            // Clicar no replay
            click(robot, 1204, 691);
            Thread.sleep(2000);
            
            // Ir para o verso (Tab)
            pressTab(robot);
            Thread.sleep(1000);

            // Voltar para o Excel (Alt + Tab)
            altTab(robot);
            Thread.sleep(1000);
            // Descer uma célula (Seta para baixo)
            pressDown(robot);
            Thread.sleep(1000);

            // Copiar linha (Ctrl + C)
            pressCtrlC(robot);
            Thread.sleep(1000);

            // Voltar para o Anki (Alt + Tab)
            altTab(robot);
            Thread.sleep(1000);
            
            // Colar linha (Ctrl + V)
            pressCtrlV(robot);
            Thread.sleep(1000);

            // Criar (Tab duas vezes e Ctrl + Enter)
            pressCtrlEnter(robot);
            Thread.sleep(1000);                      

            // Voltar para o Excel (Alt + Tab)
            altTab(robot);
            pressDown(robot);
            Thread.sleep(1000);
        }
    }
    
    private static void pressDown(Robot robot) {
    	robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
    }
    
    private static void pressTab(Robot robot) {
    	robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }
    
    private static void pressCtrlC(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    private static void pressCtrlV(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    private static void pressCtrlEnter(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    private static void pressKey(Robot robot, int keyCode) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    private static void altTab(Robot robot) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(3000);
    }

    private static void click(Robot robot, int x, int y) {
        robot.mouseMove(x, y);
        robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
    }
}
