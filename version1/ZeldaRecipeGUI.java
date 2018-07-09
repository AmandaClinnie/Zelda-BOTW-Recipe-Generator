// Amanda Hoesman-Foley
// CS 111 - 9 am
// Project 2

// import statements
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// declare the class
public class ZeldaRecipeGUI extends JFrame {

   // declare component variables
   private JPanel panel;
   private JLabel pleaseSelect;
   private JComboBox recipeSelect;
   private JLabel youSelect;
   private JTextArea selectedRecipe;
   private JButton getRecipeButton;
   private JLabel recipeImage;
   private JLabel ingredients;
   private JTextArea ingredientList;
  
   // declare final variables for window size
   final int WINDOW_WIDTH = 285;
   final int WINDOW_HEIGHT = 385;
   
   // components
   public ZeldaRecipeGUI() {
      
      // set the title
      setTitle("Zelda: BOTW Recipe Book");
      
      // specify what happens when the close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // build the panel that contains the other components
      buildPanel();
      
      // add the panel to the content pane
      add(panel);
      
      // set size and display the window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setVisible(true);
   }
   
   // build panel method
   private void buildPanel() {
   
      // create an array to hold the recipes
      String[] recipes = {"Apple Pie", "Monster Cake", "Carrot Cake", "Egg Pudding",
                            "Curry Pilaf", "Crab Risotto", "Creamy Heart Soup", "Monster Rice Balls"};
      
      // create the combo box and register the ActionListener
      recipeSelect = new JComboBox(recipes);
      recipeSelect.addActionListener(new ComboBoxListener());
      
      // instantiate the labels
      pleaseSelect = new JLabel("Please Select a Recipe:");
      youSelect = new JLabel("You Selected:");
      recipeImage = new JLabel();
      ingredients = new JLabel("Ingredients:");
      
      // set the default image for the image label
      ImageIcon recipeImagePlaceholder = new ImageIcon("recipe.jpg");
      recipeImage.setIcon(recipeImagePlaceholder);
      
      // instantiate the button and register the ActionListener
      getRecipeButton = new JButton("Get Recipe");
      getRecipeButton.addActionListener(new ButtonListener());
      
      // instantiate the selectedRecipe field
      // with a new JTextArea that has 1 row and 20 columns
      // and make it read only
      selectedRecipe = new JTextArea(1, 20);
      selectedRecipe.setEditable(false);
      
      // instantiate the ingredientList field with a new
      // JTextArea that has 5 rows and 15 columns and
      // make it read only
      ingredientList = new JTextArea(5, 15);
      ingredientList.setEditable(false);
      
      // instantiate the panel
      panel = new JPanel(); 
      
      // set the background and foreground color of the panel
      panel.setBackground(new Color(204, 243, 255));
      panel.setForeground(new Color(30, 30, 47));
      
      // set the border for the panel
      panel.setBorder(BorderFactory.createLineBorder(new Color(30, 30, 47), 3));
      
      // set the layout
      panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
      
      // add the components to the panel and add rigid area
      panel.add(pleaseSelect);
      panel.add(recipeSelect);
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(youSelect);
      panel.add(selectedRecipe);
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(getRecipeButton);
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(recipeImage);
      panel.add(Box.createRigidArea(new Dimension(0, 5)));
      panel.add(ingredients);
      panel.add(ingredientList);
      
      // set the maximum size for the components
      pleaseSelect.setMaximumSize(new Dimension(137, 35));
      recipeSelect.setMaximumSize(new Dimension(115, 25));
      youSelect.setMaximumSize(new Dimension(81, 35));
      selectedRecipe.setMaximumSize(new Dimension(115, 35));
      recipeImage.setMaximumSize(new Dimension(100, 100));
      ingredients.setMaximumSize(new Dimension(75, 35));
      ingredientList.setMaximumSize(new Dimension(131, 120));
      
      // set the alignment for the components
      pleaseSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
      recipeSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
      youSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
      selectedRecipe.setAlignmentX(Component.CENTER_ALIGNMENT);
      getRecipeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      recipeImage.setAlignmentX(Component.CENTER_ALIGNMENT);
      ingredients.setAlignmentX(Component.CENTER_ALIGNMENT);
      ingredientList.setAlignmentX(Component.CENTER_ALIGNMENT);
   }
   
   // the inner class; the ComboBox action listener
   private class ComboBoxListener implements ActionListener {
      // actionPerformed method
      public void actionPerformed(ActionEvent e) {
      
         // get the selected item
         String selection = (String) recipeSelect.getSelectedItem();
         
         // display the selected item
         selectedRecipe.setText(selection);
      }
   }
   
   // the inner class; the Button action listener
   private class ButtonListener implements ActionListener {
      // actionPerformed method
      public void actionPerformed(ActionEvent e) {
      
         // create a string to hold the string in selectedRecipe
         String str = selectedRecipe.getText();
         
         // create a switch statement to determine what
         // recipe was selected and display the recipe results
         switch (str) {
            case "Apple Pie":
               ingredientList.setText("1. Apple\n2. Tabantha Wheat\n3. Cane "
                                   + "Sugar\n4. Goat Butter\n5. n/a");
               ImageIcon image = new ImageIcon("ApplePie.png");
               recipeImage.setIcon(image);
               break;
            case "Monster Cake":
               ingredientList.setText("1. Monster Extract\n2. Tabantha Wheat\n"
                                    + "3. Cane Sugar\n4. Goat Butter\n5. n/a");
               ImageIcon image2 = new ImageIcon("MonsterCake.png");
               recipeImage.setIcon(image2);
               break;
            case "Carrot Cake":
               ingredientList.setText("1. Swift Carrot\n2. Endura Carrot\n"
                                    + "3. Tabantha Wheat\n4. Cane Sugar"
                                    + "\n5. Goat Butter");
               ImageIcon image3 = new ImageIcon("CarrotCake.PNG");
               recipeImage.setIcon(image3);
               break;
            case "Egg Pudding":
               ingredientList.setText("1. Fresh Milk\n2. Bird Egg\n"
                                    + "3. Cane Sugar\n4. n/a\n5. n/a");
               ImageIcon image4 = new ImageIcon("EggPudding.PNG");
               recipeImage.setIcon(image4);
               break;
            case "Curry Pilaf":
               ingredientList.setText("1. Hylian Rice\n2. Hylian Rice\n"
                                    + "3. Hylian Rice\n4. Goron Spice\n"
                                    + "5. Goat Butter");
               ImageIcon image5 = new ImageIcon("CurryPilaf.PNG");
               recipeImage.setIcon(image5);
               break;
            case "Crab Risotto":
               ingredientList.setText("1. Hylian Rice\n2. Goat Butter\n"
                                    + "3. Rock Salt\n4. Any Crab\n5. n/a");
               ImageIcon image6 = new ImageIcon("CrabRisotto.PNG");
               recipeImage.setIcon(image6);
               break;
            case "Creamy Heart Soup":
               ingredientList.setText("1. Hydromelon\n2. Voltfruit\n"
                                    + "3. Any Radish\n4. Fresh Milk\n5. n/a");
               ImageIcon image7 = new ImageIcon("CreamyHeartSoup.PNG");
               recipeImage.setIcon(image7);
               break;
            case "Monster Rice Balls":
               ingredientList.setText("1. Hylian Rice\n2. Rock Salt\n"
                                    + "3. Monster Extract\n4. n/a\n5. n/a");
               ImageIcon image8 = new ImageIcon("MonsterRiceBalls.PNG");
               recipeImage.setIcon(image8);
               break;
         }
      }
   }

   // the main method
   public static void main(String[] args) {
      // invoke the ZeldaRecipeGUI constructor
      ZeldaRecipeGUI myGUI = new ZeldaRecipeGUI();  
   }
}