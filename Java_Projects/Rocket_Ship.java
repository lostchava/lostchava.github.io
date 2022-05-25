import java.util.Scanner;
public class A8_1 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
       
            int stageHeight;			//Declarations
            int stageWidth;
            int numStages;
            
                stageWidth = getWidth();			//Method calls
                stageHeight = getHeight();
                numStages = getNumStages(); 
                drawRocket(stageWidth, stageHeight, numStages);
                input.close();
            }
        
        public static int getWidth() {		//Width user input method
            int width;
            Scanner input = new Scanner(System.in);
             System.out.print("Enter stage width: ");
                width = input.nextInt();
                return width;
                
        }
        
        
        
        
        
        
        public static int getHeight() {			//Height user input method
            int height;
            Scanner input = new Scanner(System.in);
             System.out.print("Enter stage height: ");    
                height = input.nextInt();
                return height;
        }
        
        
        
        
        
        
        public static int getNumStages() {		//Stages user input method (boxes)
            int stages;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter number of stages: ");    
            stages = input.nextInt();
            return stages;
        }
        
        
        
        
        
        
        public static void drawRocket(int width, int height, int stages) {	//Draw Rocket method That 
            drawCone();														//uses cones and user inputs for box
            for (int i = 0; i < stages; i++) {
                drawBox(width, height);
            }
            drawCone();
        }
        
        
        
        
        
        
        public static void drawCone() {   // Cone prints top side
            System.out.println("  *");
            System.out.println(" * *");
            System.out.println("*   *");
        }
        
        
        
        
        
        
        public static void drawBox(int width, int height) {		// Full Made Box Method
            drawBox1(width);    // horizontal
            drawBox2(width, height);    // vertical
            drawBox3(width);		//space in the box
            drawBox1(width); 	//horizontal
        }
        
        
        
        
        
        
        public static void drawBox1(int width) {   // How many in the in the horizontal line
            for (int count = 0; count< width; count++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        
        
        
        
        
        public static void drawOneRow(int width)		//DrawOneRow method for vertical line method
        {
            System.out.print("*");
            for (int spaceCount = 0; spaceCount < (width - 2); spaceCount++){    
                System.out.print(" ");
            }
            System.out.println("*");
        }
        
        
        
        
        
        
        public static void drawBox2(int width,int height) {   // how many in the vertical line
            for (int rowCount = 0; rowCount < (height - 3); rowCount++){
                drawOneRow(width);
            }
        }

        
        
        
        
        
        public static void drawBox3(int width) {			//Middle row blank space count
            System.out.print("*");
            for (int spaceCount = 0; spaceCount < (width - 2); spaceCount++){    
                System.out.print(" ");
            }
            System.out.println("*");
        }	
        
        
        
        
        
        
        public static void drawCone1() {   // Cone prints bottom side
            System.out.println("  *");
            System.out.println(" * *");
            System.out.println("*   *");
        
        }
 }
/* 
 * 
Enter stage width: 5
Enter stage height: 6
Enter number of stages: 2
*
* *
*   *
*****
*   *
*   *
*   *
*   *
*****
*****
*   *
*   *
*   *
*   *
*****
*
* *
*   *

 */
