// Amanda Hoesman-Foley
// amanda.clinnie@gmail.com
// The Legend of Zelda: BOTW Recipe Generator
// Last Edited: 19 June 2017

// import statements
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// declare the class
public class ZeldaRecipeGenerator extends JFrame {

   // create the arrays of recipes
   String[] vegetarianEntrees = {"Creamy Heart Soup", "Pumpkin Stew", "Veggie "
                                 + "Cream Soup", "Cream of Mushroom Soup", 
                                 "Cream of Vegetable Soup", "Carrot Stew", 
                                 "Vegetable Risotto", "Mushroom Risotto", 
                                 "Curry Pilaf", "Mushroom Rice Balls", 
                                 "Veggie Rice Balls", "Curry Rice", 
                                 "Fried Egg and Rice", "Mushroom Omelet", 
                                 "Vegetable Omelet", "Vegetable Curry", 
                                 "Fragrant Mushroom Saute", "Herb Saute", 
                                 "Salt-Grilled Greens", "Salt-Grilled Mushrooms", 
                                 "Steamed Mushrooms", "Mushroom Skewer", 
                                 "Copious Mushroom Skewer", "Fried Wild Greens", 
                                 "Copious Fried Wild Greens", "Omelet"};
                                 
   String[] seafoodEntrees = {"Clam Chowder", "Creamy Seafood Soup", "Seafood "
                              + "Curry", "Salmon Risotto", "Crab Risotto", 
                              "Seafood Fried Rice", "Seafood Paella", "Crab"
                              + " Omelet with Rice", "Seafood Rice Balls", 
                              "Fish Pie", "Salmon Meuniere", "Porgy Meuniere",
                              "Seafood Meuniere", "Glazed Seafood", "Crab "
                              + "Stir-Fry", "Salt-Grilled Crab", "Salt-Grilled"
                              + " Fish", "Copious Fish Skewers", "Spicy "
                              + "Peppered Seafood", "Steamed Fish", "Fish and"
                              + " Mushroom Skewer", "Seafood Skewer", "Fish Skewer"};
                              
   String[] poultryEntrees = {"Gourmet Meat Stew", "Prime Meat Stew", "Meat Stew", 
                              "Creamy Meat Soup", "Meat Curry", "Prime Meat Curry", 
                              "Gourmet Meat Curry", "Poultry Curry", "Prime "
                              + "Poultry Curry", "Gourmet Poultry Curry", "Meaty"
                              + " Rice Balls", "Meat-Stuffed Pumpkins", "Meat Pie",  
                              "Poultry Pilaf", "Prime Poultry Pilaf", "Gourmet"
                              + " Poultry Pilaf", "Meat and Rice Bowl", "Prime "
                              + "Meat and Rice Bowl", "Gourmet Meat and Rice Bowl", 
                              "Glazed Meat", "Spiced Meat Skewer", "Prime "
                              + "Spiced Meat Skewer", "Gourmet Spiced Meat "
                              + "Skewer", "Salt-Grilled Meat", "Salt-Grilled "
                              + "Prime Meat", "Salt-Grilled Gourmet Meat",  
                              "Copious Meat Skewers", "Pepper Steak", "Steamed " 
                              + "Meat", "Meat and Mushroom Skewer", "Meat Skewer"};
                              
   String[] surfEntrees = {"Meat and Seafood Fry", "Prime Meat and Seafood Fry", 
                           "Gourmet Meat and Seafood Fry"};
   
   String[] desserts = {"Apple Pie", "Pumpkin Pie", "Fruit Pie", "Fruitcake", 
                        "Carrot Cake", "Nutcake", "Plain Crepe", "Honey Crepe", 
                        "Wildberry Crepe", "Egg Tart", "Egg Pudding", "Fried "
                        + "Bananas", "Hot Buttered Apple", "Honeyed Apple", 
                        "Honeyed Fruits", "Honey Candy"};
   
   String[] monsterFoods = {"Monster Soup", "Monster Curry", "Monster Rice "
                              + "Balls", "Monster Stew", "Monster Cake"};
   
   String[] sides = {"Sauteed Peppers", "Fairy Tonic", "Sauteed Nuts", "Simmered"
                     + " Fruit", "Warm Milk", "Wheat Bread", "Steamed Fruit", 
                     "Fruit and Mushroom Mix", "Copious Simmered Fruit", 
                     "Glazed Mushrooms", "Glazed Veggies"};
                     
   // create a string to hold the selected recipe
   String myRecipe = "";

   // declare component variables
   private JPanel panel;
   private JLabel selectRecipeType;
   private JRadioButton vegetarianEntreeButton;
   private JRadioButton seafoodEntreeButton;
   private JRadioButton poultryEntreeButton;
   private JRadioButton surfEntreeButton;
   private JRadioButton dessertsButton;
   private JRadioButton monsterButton;
   private JRadioButton sidesButton;
   private ButtonGroup recipeGroup;
   private JLabel recipeLabel;
   private JComboBox recipeSelect;
   private JButton getRecipeButton;
   private JLabel recipeImage;
   private JLabel recipeName;
   private JLabel ingredients;
   private JTextArea ingredientList;
  
   // declare final variables for window size
   final int WINDOW_WIDTH = 464;
   final int WINDOW_HEIGHT = 566;
   
   // components
   public ZeldaRecipeGenerator() {
      
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
      String[] recipes = {"Please select a recipe type."};
            
      // instantiate the first label
      selectRecipeType = new JLabel("Select a Recipe Type:");
      
      // create the radio buttons
      vegetarianEntreeButton = new JRadioButton("Vegetarian Entrees");
      seafoodEntreeButton = new JRadioButton("Seafood Entrees");
      poultryEntreeButton = new JRadioButton("Poultry and Meat Entrees");
      surfEntreeButton = new JRadioButton("Surf and Turf Entrees");
      dessertsButton = new JRadioButton("Desserts");
      monsterButton = new JRadioButton("Monster Foods");
      sidesButton = new JRadioButton("Sides and Snacks");
      
      // create the radio button groups
      recipeGroup = new ButtonGroup();
      
      // add the recipe buttons to the recipeGroup
      recipeGroup.add(vegetarianEntreeButton);
      recipeGroup.add(seafoodEntreeButton);
      recipeGroup.add(poultryEntreeButton);
      recipeGroup.add(surfEntreeButton);
      recipeGroup.add(dessertsButton);
      recipeGroup.add(monsterButton);
      recipeGroup.add(sidesButton);
      
      // register an action listener for the radio buttons
      vegetarianEntreeButton.addActionListener(new RadioButtonListener());
      seafoodEntreeButton.addActionListener(new RadioButtonListener());
      poultryEntreeButton.addActionListener(new RadioButtonListener());
      surfEntreeButton.addActionListener(new RadioButtonListener());
      dessertsButton.addActionListener(new RadioButtonListener());
      monsterButton.addActionListener(new RadioButtonListener());
      sidesButton.addActionListener(new RadioButtonListener());
      
      // instantiate the second label
      recipeLabel = new JLabel("Select a Recipe:");
      
      // instantiate the combo box and register the ActionListener
      recipeSelect = new JComboBox(recipes);
      recipeSelect.addActionListener(new ComboBoxListener());
      
      // instantiate the button and register the ActionListener
      getRecipeButton = new JButton("Get Recipe");
      getRecipeButton.addActionListener(new ButtonListener());
      
      // create the image label, set the default image for the label,
      // and set the size for the label
      recipeImage = new JLabel();
      ImageIcon recipeImagePlaceholder = new ImageIcon("recipe.jpg");
      recipeImage.setIcon(recipeImagePlaceholder);
      recipeImage.setSize(80, 80);
      
      // instantiate the last two labels
      recipeName = new JLabel("");
      ingredients = new JLabel("Ingredients:");
      
      // instantiate the ingredientList field with a new
      // JTextArea that has 5 rows and 25 columns and 
      // make it read only
      ingredientList = new JTextArea(5, 21);
      ingredientList.setEditable(false);
      
      // instantiate the panel
      panel = new JPanel(); 
      
      // set the background and foreground color of the panel
      panel.setBackground(new Color(206, 180, 152));
      
      // set the border for the panel
      panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
      
      // set up the panel for absolute positioning
      panel.setLayout(null);
 
      // set the layout properties for selectRecipeType and add it to the panel
      selectRecipeType.setBounds(14, 9, 200, 25);
      panel.add(selectRecipeType);
      
      // set the layout properties for vegetarianEntreeButton 
      // and add it to the panel
      vegetarianEntreeButton.setBounds(14, 35, 200, 25);
      panel.add(vegetarianEntreeButton);
      
      // set the layout properties for seafoodEntreeButton and add it to the panel
      seafoodEntreeButton.setBounds(14, 61, 200, 25);
      panel.add(seafoodEntreeButton);
      
      // set the layout properties for poultryEntreeButton and add it to the panel
      poultryEntreeButton.setBounds(14, 87, 200, 25);
      panel.add(poultryEntreeButton);
      
      // set the layout properties for surfEntreeButton and add it to the panel
      surfEntreeButton.setBounds(14, 113, 200, 25);
      panel.add(surfEntreeButton);
      
      // set the layout properties for dessertsButton and add it to the panel
      dessertsButton.setBounds(14, 139, 200, 25);
      panel.add(dessertsButton);
      
      // set the layout properties for monsterButton and add it to the panel
      monsterButton.setBounds(14, 165, 200, 25);
      panel.add(monsterButton);
      
      // set the layout properties for sidesButton and add it to the panel
      sidesButton.setBounds(14, 191, 200, 25);
      panel.add(sidesButton);
      
      // set the layout properties for recipeLabel and add it to the panel
      recipeLabel.setBounds(14, 226, 200, 25);
      panel.add(recipeLabel);
      
      // set the layout properties for recipeSelect and add it to the panel
      recipeSelect.setBounds(14, 252, 200, 30);
      panel.add(recipeSelect);
      
      // set the layout properties for getRecipeButton and add it to the panel
      getRecipeButton.setBounds(249, 252, 185, 30);
      panel.add(getRecipeButton);
      
      // set the layout properties for recipeImage and add it to the panel
      recipeImage.setBounds(192, 293, 80, 80);
      panel.add(recipeImage);
      
      // set the layout properties for recipeName and add it to the panel
      recipeName.setBounds(87, 384, 250, 25);
      panel.add(recipeName);
      
      // set the layout properties for ingredients and add it to the panel
      ingredients.setBounds(87, 400, 175, 25);
      panel.add(ingredients);
      
      // set the layout properties for ingredientList and add it to the panel
      ingredientList.setBounds(87, 426, 275, 81);
      panel.add(ingredientList);
   }
   
   // the inner class; the radio buttons action listener
   private class RadioButtonListener implements ActionListener {
      // actionPerformed method
      public void actionPerformed(ActionEvent e) {
         if (vegetarianEntreeButton.isSelected()) {
            recipeSelect.removeAllItems();
            for(int i = 0; i < 26; i++){
               recipeSelect.addItem(vegetarianEntrees[i]);
            }
         } else if (seafoodEntreeButton.isSelected()) {
            recipeSelect.removeAllItems();
            for(int i = 0; i < 23; i++){
               recipeSelect.addItem(seafoodEntrees[i]);
            }
         } else if (poultryEntreeButton.isSelected()) {
            recipeSelect.removeAllItems();
            for(int i = 0; i < 31; i++){
               recipeSelect.addItem(poultryEntrees[i]);
            }
         } else if (surfEntreeButton.isSelected()) {
            recipeSelect.removeAllItems();
            for(int i = 0; i < 3; i++){
               recipeSelect.addItem(surfEntrees[i]);
            }
         } else if (dessertsButton.isSelected()) {
            recipeSelect.removeAllItems();
            for(int i = 0; i < 16; i++){
               recipeSelect.addItem(desserts[i]);
            }
         } else if (monsterButton.isSelected()) {
            recipeSelect.removeAllItems();
            for(int i = 0; i < 5; i++){
               recipeSelect.addItem(monsterFoods[i]);
            }
         } else if (sidesButton.isSelected()) {
            recipeSelect.removeAllItems();
            for(int i = 0; i < 11; i++){
               recipeSelect.addItem(sides[i]);
            }
         }
      }   
   }
   
   // the inner class; the ComboBox action listener
   private class ComboBoxListener implements ActionListener {
      // actionPerformed method
      public void actionPerformed(ActionEvent e) {
      
         // get the selected item
         myRecipe = (String) recipeSelect.getSelectedItem();
      }
   }
   
   // the inner class; the Button action listener
   private class ButtonListener implements ActionListener {
      // actionPerformed method
      public void actionPerformed(ActionEvent e) {
      
         // switch on myRecipe - change image, display recipe
         // name, and display recipe ingredients
         switch (myRecipe) {
            // vegetarian entrees
            case "Creamy Heart Soup":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image = new ImageIcon("CreamyHeartSoup.PNG");
               recipeImage.setIcon(image);
               // set ingredientList           
               ingredientList.setText("1. Any radish\n2. Hydromelon\n3. Voltfruit"
                                   + "\n4. Fresh Milk\n5. n/a");
               break;
            case "Pumpkin Stew":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image2 = new ImageIcon("PumpkinStew.PNG");
               recipeImage.setIcon(image2);
               // set ingredientList           
               ingredientList.setText("1. Fortified Pumpkin\n2. Goat Butter\n3. "
                                       + "Fresh Milk\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Veggie Cream Soup":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image3 = new ImageIcon("VeggieCreamSoup.PNG");
               recipeImage.setIcon(image3);
               // set ingredientList           
               ingredientList.setText("1. Any carrot or pumpkin\n2. Fresh Milk"
                                       + "\n3. Rock Salt\n4. n/a\n5. n/a");
               break;
            case "Cream of Mushroom Soup":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image4 = new ImageIcon("CreamOfMushroomSoup.PNG");
               recipeImage.setIcon(image4);
               // set ingredientList           
               ingredientList.setText("1. Any mushroom\n2. Any vegetable, herb"
                                       + ", or flower\n3. Fresh Milk\n4. "
                                       + "Rock Salt\n5. n/a");
               break;
            case "Cream of Vegetable Soup":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image5 = new ImageIcon("CreamOfVegetableSoup.PNG");
               recipeImage.setIcon(image5);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable, herb, or flower\n2. "
                                       + "Fresh Milk\n3. Rock Salt\n4. n/a\n5. n/a");
               break;
            case "Carrot Stew":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image6 = new ImageIcon("CarrotStew.PNG");
               recipeImage.setIcon(image6);
               // set ingredientList           
               ingredientList.setText("1. Any carrot\n2. Goat Butter\n3. Fresh"
                                       + " Milk\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Vegetable Risotto":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image7 = new ImageIcon("VegetableRisotto.PNG");
               recipeImage.setIcon(image7);
               // set ingredientList           
               ingredientList.setText("1. Any carrot or pumpkin\n2. Goat Butter"
                                       + "\n3. Hylian Rice\n4. Rock Salt\n5. n/a");
               break;
            case "Mushroom Risotto":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image8 = new ImageIcon("MushroomRisotto.PNG");
               recipeImage.setIcon(image8);
               // set ingredientList           
               ingredientList.setText("1. Any mushroom\n2. Hylian Rice\n3. "
                                       + "Goat Butter\n4. Rock Salt\n5. n/a");
               break;
            case "Curry Pilaf":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image9 = new ImageIcon("CurryPilaf.PNG");
               recipeImage.setIcon(image9);
               // set ingredientList           
               ingredientList.setText("1. Goat Butter\n2. Goron Spice\n3. "
                                       + "Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Mushroom Rice Balls":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image10 = new ImageIcon("MushroomRiceBalls.PNG");
               recipeImage.setIcon(image10);
               // set ingredientList           
               ingredientList.setText("1. Hylian Rice\n2. Any mushroom\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Veggie Rice Balls":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image11 = new ImageIcon("VeggieRiceBalls.PNG");
               recipeImage.setIcon(image11);
               // set ingredientList           
               ingredientList.setText("1. Hylian Rice\n2. Any vegetable, herb"
                                       + ", or flower\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Curry Rice":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image12 = new ImageIcon("CurryRice.PNG");
               recipeImage.setIcon(image12);
               // set ingredientList           
               ingredientList.setText("1. Goron Spice\n2. Hylian Rice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Fried Egg and Rice":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image13 = new ImageIcon("FriedEggAndRice.PNG");
               recipeImage.setIcon(image13);
               // set ingredientList           
               ingredientList.setText("1. Bird Egg\n2. Hylian Rice\n3. n/a"
                                       + "\n4. n/a\n5. n/a");
               break;
            case "Mushroom Omelet":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image14 = new ImageIcon("MushroomOmelet.PNG");
               recipeImage.setIcon(image14);
               // set ingredientList           
               ingredientList.setText("1. Any mushroom\n2. Bird Egg\n3. "
                                       + "Goat Butter\n4. Rock Salt\n5. n/a");
               break;
            case "Vegetable Omelet":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image15 = new ImageIcon("VegetableOmelet.PNG");
               recipeImage.setIcon(image15);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable, herb, or flower\n2. "
                                       + "Bird Egg\n3. Goat Butter\n4. Rock "
                                       + "Salt\n5. n/a");
               break;
            case "Vegetable Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image16 = new ImageIcon("VegetableCurry.PNG");
               recipeImage.setIcon(image16);
               // set ingredientList           
               ingredientList.setText("1. Any carrot or pumpkin\n2. Goron"
                                       + " Spice\n3. Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Fragrant Mushroom Saute":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image17 = new ImageIcon("FragrantMushroomSaute.PNG");
               recipeImage.setIcon(image17);
               // set ingredientList           
               ingredientList.setText("1. Any mushroom\n2. Goron Spice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Herb Saute":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image18 = new ImageIcon("HerbSaute.PNG");
               recipeImage.setIcon(image18);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable, herb, or flower\n2. "
                                       + "Goron Spice\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Salt-Grilled Greens":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image19 = new ImageIcon("SaltGrilledGreens.PNG");
               recipeImage.setIcon(image19);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable, herb, or flower\n2. "
                                       + "Rock Salt\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Salt-Grilled Mushrooms":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image20 = new ImageIcon("SaltGrilledMushrooms.PNG");
               recipeImage.setIcon(image20);
               // set ingredientList           
               ingredientList.setText("1. Any mushroom\n2. Rock Salt\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Steamed Mushrooms":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image21 = new ImageIcon("SteamedMushrooms.PNG");
               recipeImage.setIcon(image21);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable, herb, or flower\n2. "
                                       + "Any mushroom\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Mushroom Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image22 = new ImageIcon("MushroomSkewer.PNG");
               recipeImage.setIcon(image22);
               // set ingredientList           
               ingredientList.setText("1. Any mushroom\n2. n/a\n3. n/a\n4. "
                                       + "n/a\n5. n/a");
               break;
            case "Copious Mushroom Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image23 = new ImageIcon("CopiousMushroomSkewers.PNG");
               recipeImage.setIcon(image23);
               // set ingredientList           
               ingredientList.setText("1. Any four different mushrooms\n2. "
                                       + "n/a\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Fried Wild Greens":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image24 = new ImageIcon("FriedWildGreens.PNG");
               recipeImage.setIcon(image24);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable, herb, or flower combination"
                                       + "\n2. n/a\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Copious Fried Wild Greens":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image25 = new ImageIcon("CopiousFriedWildGreens.PNG");
               recipeImage.setIcon(image25);
               // set ingredientList           
               ingredientList.setText("1. Any four different vegetables, herbs,"
                                       + " or flowers\n2. n/a\n3. n/a\n4. "
                                       + "n/a\n5. n/a");
               break;
            case "Omelet":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image26 = new ImageIcon("Omelet.PNG");
               recipeImage.setIcon(image26);
               // set ingredientList           
               ingredientList.setText("1. Bird Egg\n2. n/a\n3. n/a\n4. n/a\n5. n/a");
               break;
               
            // seafood entrees
            case "Clam Chowder":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image27 = new ImageIcon("ClamChowder.PNG");
               recipeImage.setIcon(image27);
               // set ingredientList           
               ingredientList.setText("1. Hearty Blueshell Snail\n2. "
                                       + "Goat Butter\n3. Fresh Milk\n4. "
                                       + "Tabantha Wheat\n5. n/a");
               break;
            case "Creamy Seafood Soup":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image28 = new ImageIcon("CreamySeafoodSoup.PNG");
               recipeImage.setIcon(image28);
               // set ingredientList           
               ingredientList.setText("1. Any seafood\n2. Any vegetable"
                                       + ", herb, or flower\n3. Rock Salt\n4. "
                                       + "Fresh Milk\n5. n/a");
               break;
            case "Seafood Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image29 = new ImageIcon("SeafoodCurry.PNG");
               recipeImage.setIcon(image29);
               // set ingredientList           
               ingredientList.setText("1. Hearty Blueshell Snail or any Porgy\n2. "
                                       + "Hylian Rice\n3. Goron Spice\n4. "
                                       + "n/a\n5. n/a");
               break;
            case "Salmon Risotto":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image30 = new ImageIcon("SalmonRisotto.PNG");
               recipeImage.setIcon(image30);
               // set ingredientList           
               ingredientList.setText("1. Hearty Salmon\n2. Rock Salt"
                                       + "\n3. Hylian Rice\n4. Goat "
                                       + "Butter\n5. n/a");
               break;
            case "Crab Risotto":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image31 = new ImageIcon("CrabRisotto.PNG");
               recipeImage.setIcon(image31);
               // set ingredientList           
               ingredientList.setText("1. Any crab\n2. Rock Salt\n3. "
                                       + "Hylian Rice\n4. Goat Butter"
                                       + "\n5. n/a");
               break;
            case "Seafood Fried Rice":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image32 = new ImageIcon("SeafoodFriedRice.PNG");
               recipeImage.setIcon(image32);
               // set ingredientList           
               ingredientList.setText("1. Hearty Blueshell Snail or any Porgy\n2."
                                       + " Rock Salt\n3. Hylian Rice\n4. "
                                       + "n/a\n5. n/a");
               break;
            case "Seafood Paella":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image33 = new ImageIcon("SeafoodPaella.PNG");
               recipeImage.setIcon(image33);
               // set ingredientList           
               ingredientList.setText("1. Any Porgy\n2. Hearty Blueshell Snail"
                                       + "\n3. Rock Salt\n4. Goat Butter"
                                       + "\n5. Hylian Rice");
               break;
            case "Crab Omelet with Rice":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image34 = new ImageIcon("CrabOmeletWithRice.PNG");
               recipeImage.setIcon(image34);
               // set ingredientList           
               ingredientList.setText("1. Any crab\n2. Bird Egg\n3. Rock"
                                       + " Salt\n4. Hylian Rice\n5. n/a");
               break;
            case "Seafood Rice Balls":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image35 = new ImageIcon("SeafoodRiceBalls.PNG");
               recipeImage.setIcon(image35);
               // set ingredientList           
               ingredientList.setText("1. Any fish\n2. Hylian Rice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Fish Pie":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image36 = new ImageIcon("FishPie.PNG");
               recipeImage.setIcon(image36);
               // set ingredientList           
               ingredientList.setText("1. Any seafood\n2. Rock Salt\n3. "
                                       + "Goat Butter\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Salmon Meuniere":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image37 = new ImageIcon("SalmonMeuniere.PNG");
               recipeImage.setIcon(image37);
               // set ingredientList           
               ingredientList.setText("1. Hearty Salmon\n2. Goat Butter"
                                       + "\n3. Tabantha Wheat\n4. n/a\n5. n/a");
               break;
            case "Porgy Meuniere":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image38 = new ImageIcon("PorgyMeuniere.PNG");
               recipeImage.setIcon(image38);
               // set ingredientList           
               ingredientList.setText("1. Any Porgy\n2. Goat Butter\n3. "
                                       + "Tabantha Wheat\n4. n/a\n5. n/a");
               break;
            case "Seafood Meuniere":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image39 = new ImageIcon("SeafoodMeuniere.PNG");
               recipeImage.setIcon(image39);
               // set ingredientList           
               ingredientList.setText("1. Any seafood excluding Hearty Salmon"
                                       + " or Porgy\n2. Goat Butter\n3. "
                                       + "Tabantha Wheat\n4. n/a\n5. n/a");
               break;
            case "Glazed Seafood":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image40 = new ImageIcon("GlazedSeafood.PNG");
               recipeImage.setIcon(image40);
               // set ingredientList           
               ingredientList.setText("1. Courser Bee Honey\n2. Any seafood\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Crab Stir-Fry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image41 = new ImageIcon("CrabStirFry.PNG");
               recipeImage.setIcon(image41);
               // set ingredientList           
               ingredientList.setText("1. Any crab\n2. Goron Spice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Salt-Grilled Crab":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image42 = new ImageIcon("SaltGrilledCrab.PNG");
               recipeImage.setIcon(image42);
               // set ingredientList           
               ingredientList.setText("1. Any crab\n2. Rock Salt\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Salt-Grilled Fish":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image43 = new ImageIcon("SaltGrilledFish.PNG");
               recipeImage.setIcon(image43);
               // set ingredientList           
               ingredientList.setText("1. Any fish\n2. Rock Salt\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Copious Fish Skewers":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image44 = new ImageIcon("CopiousFishSkewers.PNG");
               recipeImage.setIcon(image44);
               // set ingredientList           
               ingredientList.setText("1. Any four different fish\n2. n/a\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Spicy Peppered Seafood":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image45 = new ImageIcon("SpicyPepperedSeafood.PNG");
               recipeImage.setIcon(image45);
               // set ingredientList           
               ingredientList.setText("1. Any seafood\n2. Spicy seafood\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Steamed Fish":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image46 = new ImageIcon("SteamedFish.PNG");
               recipeImage.setIcon(image46);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable, herb, or flower\n2. "
                                       + "Any fish\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Fish and Mushroom Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image47 = new ImageIcon("FishAndMushroomSkewer.PNG");
               recipeImage.setIcon(image47);
               // set ingredientList           
               ingredientList.setText("1. Any fish\n2. Any mushroom\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Seafood Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image48 = new ImageIcon("SeafoodSkewer.PNG");
               recipeImage.setIcon(image48);
               // set ingredientList           
               ingredientList.setText("1. Any snail or crab\n2. n/a\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Fish Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image49 = new ImageIcon("FishSkewer.PNG");
               recipeImage.setIcon(image49);
               // set ingredientList           
               ingredientList.setText("1. Any fish\n2. n/a\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
               
            // poultry and meat entrees
            case "Gourmet Meat Stew":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image50 = new ImageIcon("GourmetMeatStew.PNG");
               recipeImage.setIcon(image50);
               // set ingredientList           
               ingredientList.setText("1. Raw Gourmet Meat or Raw Whole Bird"
                                       + "\n2. Fresh Milk\n3. Goat Butter"
                                       + "\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Prime Meat Stew":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image51 = new ImageIcon("PrimeMeatStew.PNG");
               recipeImage.setIcon(image51);
               // set ingredientList           
               ingredientList.setText("1. Raw Prime Meat or Raw Bird Thigh"
                                       + "\n2. Fresh Milk\n3. Goat Butter"
                                       + "\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Meat Stew":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image52 = new ImageIcon("MeatStew.PNG");
               recipeImage.setIcon(image52);
               // set ingredientList           
               ingredientList.setText("1. Raw Meat or Raw Bird Drumstick"
                                       + "\n2. Fresh Milk\n3. Goat Butter"
                                       + "\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Creamy Meat Soup":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image53 = new ImageIcon("CreamyMeatSoup.PNG");
               recipeImage.setIcon(image53);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. Any vegetable, herb"
                                       + ", or flower\n3. Fresh Milk"
                                       + "\n4. Rock Salt\n5. n/a");
               break;
            case "Meat Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image54 = new ImageIcon("MeatCurry.PNG");
               recipeImage.setIcon(image54);
               // set ingredientList           
               ingredientList.setText("1. Raw Meat\n2. Goron Spice\n3. "
                                       + "Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Prime Meat Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image55 = new ImageIcon("PrimeMeatCurry.PNG");
               recipeImage.setIcon(image55);
               // set ingredientList           
               ingredientList.setText("1. Raw Prime Meat\n2. Goron Spice\n3. "
                                       + "Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Gourmet Meat Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image56 = new ImageIcon("GourmetMeatCurry.PNG");
               recipeImage.setIcon(image56);
               // set ingredientList           
               ingredientList.setText("1. Raw Gourmet Meat\n2. Goron Spice\n3. "
                                       + "Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Poultry Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image57 = new ImageIcon("PoultryCurry.PNG");
               recipeImage.setIcon(image57);
               // set ingredientList           
               ingredientList.setText("1. Raw Bird Drumstick\n2. Goron Spice\n3. "
                                       + "Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Prime Poultry Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image58 = new ImageIcon("PrimePoultryCurry.PNG");
               recipeImage.setIcon(image58);
               // set ingredientList           
               ingredientList.setText("1. Raw Bird Thigh\n2. Goron Spice\n3. "
                                       + "Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Gourmet Poultry Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image59 = new ImageIcon("GourmetPoultryCurry.PNG");
               recipeImage.setIcon(image59);
               // set ingredientList           
               ingredientList.setText("1. Raw Whole Bird\n2. Goron Spice\n3. "
                                       + "Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Meaty Rice Balls":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image60 = new ImageIcon("MeatyRiceBalls.PNG");
               recipeImage.setIcon(image60);
               // set ingredientList           
               ingredientList.setText("1. Any Meat\n2. Hylian Rice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Meat-Stuffed Pumpkins":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image61 = new ImageIcon("MeatStuffedPumpkins.PNG");
               recipeImage.setIcon(image61);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. Fortified Pumpkin\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Meat Pie":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image62 = new ImageIcon("MeatPie.PNG");
               recipeImage.setIcon(image62);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. Goat Butter\n3. "
                                       + "Rock Salt\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Poultry Pilaf":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image63 = new ImageIcon("PoultryPilaf.PNG");
               recipeImage.setIcon(image63);
               // set ingredientList           
               ingredientList.setText("1. Raw Bird Drumstick\n2. Bird Egg\n3. "
                                       + "Goat Butter\n4. Hylian Rice\n5. n/a");
               break;
            case "Prime Poultry Pilaf":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image64 = new ImageIcon("PrimePoultryPilaf.PNG");
               recipeImage.setIcon(image64);
               // set ingredientList           
               ingredientList.setText("1. Raw Bird Thigh\n2. Bird Egg\n3. "
                                       + "Goat Butter\n4. Hylian Rice\n5. n/a");
               break;
            case "Gourmet Poultry Pilaf":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image65 = new ImageIcon("GourmetPoultryPilaf.PNG");
               recipeImage.setIcon(image65);
               // set ingredientList           
               ingredientList.setText("1. Raw Whole Bird\n2. Bird Egg\n3. "
                                       + "Goat Butter\n4. Hylian Rice\n5. n/a");
               break;
            case "Meat and Rice Bowl":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image66 = new ImageIcon("MeatAndRiceBowl.PNG");
               recipeImage.setIcon(image66);
               // set ingredientList           
               ingredientList.setText("1. Raw Meat or Raw Bird Drumstick\n2. "
                                       + "Rock Salt\n3. Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Prime Meat and Rice Bowl":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image67 = new ImageIcon("PrimeMeatAndRiceBowl.PNG");
               recipeImage.setIcon(image67);
               // set ingredientList           
               ingredientList.setText("1. Raw Prime Meat or Raw Bird Thigh\n2. "
                                       + "Rock Salt\n3. Hylian Rice\n4. n/a\n"
                                       + "5. n/a");
               break;
            case "Gourmet Meat and Rice Bowl":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image68 = new ImageIcon("GourmetMeatAndRiceBowl.PNG");
               recipeImage.setIcon(image68);
               // set ingredientList           
               ingredientList.setText("1. Raw Gourmet Meat or Raw Whole Bird\n2. "
                                       + "Rock Salt\n3. Hylian Rice"
                                       + "\n4. n/a\n5. n/a");
               break;
            case "Glazed Meat":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image69 = new ImageIcon("GlazedMeat.PNG");
               recipeImage.setIcon(image69);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. Courser Bee Honey\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Spiced Meat Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image70 = new ImageIcon("SpicedMeatSkewer.PNG");
               recipeImage.setIcon(image70);
               // set ingredientList           
               ingredientList.setText("1. Raw Meat\n2. Goron Spice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Prime Spiced Meat Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image71 = new ImageIcon("PrimeSpicedMeatSkewer.PNG");
               recipeImage.setIcon(image71);
               // set ingredientList           
               ingredientList.setText("1. Raw Prime Meat\n2. Goron Spice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Gourmet Spiced Meat Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image72 = new ImageIcon("GourmetSpicedMeatSkewer.PNG");
               recipeImage.setIcon(image72);
               // set ingredientList           
               ingredientList.setText("1. Raw Gourmet Meat\n2. Goron Spice\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Salt-Grilled Meat":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image73 = new ImageIcon("SaltGrilledMeat.PNG");
               recipeImage.setIcon(image73);
               // set ingredientList           
               ingredientList.setText("1. Raw Meat or Raw Bird Drumstick\n2. "
                                       + "Rock Salt\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Salt-Grilled Prime Meat":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image74 = new ImageIcon("SaltGrilledPrimeMeat.PNG");
               recipeImage.setIcon(image74);
               // set ingredientList           
               ingredientList.setText("1. Raw Prime Meat or Raw Bird Thigh\n2."
                                       + " Rock Salt\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Salt-Grilled Gourmet Meat":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image75 = new ImageIcon("SaltGrilledGourmetMeat.PNG");
               recipeImage.setIcon(image75);
               // set ingredientList           
               ingredientList.setText("1. Raw Gourmet Meat or Raw Whole Bird\n2."
                                       + " Rock Salt\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Copious Meat Skewers":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image76 = new ImageIcon("CopiousMeatSkewers.PNG");
               recipeImage.setIcon(image76);
               // set ingredientList           
               ingredientList.setText("1. Any four different meats\n2. n/a\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Pepper Steak":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image77 = new ImageIcon("PepperSteak.PNG");
               recipeImage.setIcon(image77);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. Spicy Pepper\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Steamed Meat":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image78 = new ImageIcon("SteamedMeat.PNG");
               recipeImage.setIcon(image78);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. Any vegetable, herb, or "
                                       + "flower\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Meat and Mushroom Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image79 = new ImageIcon("MeatAndMushroomSkewer.PNG");
               recipeImage.setIcon(image79);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. Any mushroom\n3. "
                                       + "n/a\n4. n/a\n5. n/a");
               break;
            case "Meat Skewer":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image80 = new ImageIcon("MeatSkewer.PNG");
               recipeImage.setIcon(image80);
               // set ingredientList           
               ingredientList.setText("1. Any meat\n2. n/a\n3. n/a\n4. n/a\n5. n/a");
               break;
               
            // surf and turf entrees
            case "Meat and Seafood Fry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image81 = new ImageIcon("MeatAndSeafoodFry.PNG");
               recipeImage.setIcon(image81);
               // set ingredientList           
               ingredientList.setText("1. Raw Meat or Raw Bird Drumstick\n2. "
                                       + "Any seafood\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Prime Meat and Seafood Fry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image82 = new ImageIcon("PrimeMeatAndSeafoodFry.PNG");
               recipeImage.setIcon(image82);
               // set ingredientList           
               ingredientList.setText("1. Raw Prime Meat or Raw Bird Thigh\n2. "
                                       + "Any seafood\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Gourmet Meat and Seafood Fry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image83 = new ImageIcon("GourmetMeatAndSeafoodFry.PNG");
               recipeImage.setIcon(image83);
               // set ingredientList           
               ingredientList.setText("1. Raw Gourmet Meat or Raw Whole Bird\n2. "
                                       + "Any seafood\n3. n/a\n4. n/a\n5. n/a");
               break;
               
            // desserts
            case "Apple Pie":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image84 = new ImageIcon("ApplePie.PNG");
               recipeImage.setIcon(image84);
               // set ingredientList           
               ingredientList.setText("1. Apple\n2. Goat Butter\n3. "
                                       + "Cane Sugar\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Pumpkin Pie":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image85 = new ImageIcon("PumpkinPie.PNG");
               recipeImage.setIcon(image85);
               // set ingredientList           
               ingredientList.setText("1. Fortified Pumpkin\n2. Goat Butter"
                                       + "\n3. Cane Sugar\n4. Tabantha Wheat"
                                       + "\n5. n/a");
               break;
            case "Fruit Pie":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image86 = new ImageIcon("FruitPie.PNG");
               recipeImage.setIcon(image86);
               // set ingredientList           
               ingredientList.setText("1. Any fruit excluding apple or pumpkin"
                                       + "\n2. Goat Butter\n3. Cane Sugar"
                                       + "\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Fruitcake":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image87 = new ImageIcon("Fruitcake.PNG");
               recipeImage.setIcon(image87);
               // set ingredientList           
               ingredientList.setText("1. Wildberry or Apple\n2. Any other"
                                       + " fruit\n3. Cane Sugar"
                                       + "\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Carrot Cake":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image88 = new ImageIcon("CarrotCake.PNG");
               recipeImage.setIcon(image88);
               // set ingredientList           
               ingredientList.setText("1. Any carrot\n2. Goat Butter"
                                       + "\n3. Cane Sugar\n4. Tabantha"
                                       + " Wheat\n5. n/a");
               break;
            case "Nutcake":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image89 = new ImageIcon("Nutcake.PNG");
               recipeImage.setIcon(image89);
               // set ingredientList           
               ingredientList.setText("1. Any nut\n2. Goat Butter\n3. "
                                       + "Cane Sugar\n4. Tabantha Wheat\n5. n/a");
               break;
            case "Plain Crepe":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image90 = new ImageIcon("PlainCrepe.PNG");
               recipeImage.setIcon(image90);
               // set ingredientList           
               ingredientList.setText("1. Tabantha Wheat\n2. Fresh Milk"
                                       + "\n3. Bird Egg\n4. Cane Sugar\n5. n/a");
               break;
            case "Honey Crepe":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image91 = new ImageIcon("HoneyCrepe.PNG");
               recipeImage.setIcon(image91);
               // set ingredientList           
               ingredientList.setText("1. Courser Bee Honey\n2. Cane Sugar"
                                       + "\n3. Fresh Milk\n4. Bird Egg"
                                       + "\n5. Tabantha Wheat");
               break;
            case "Wildberry Crepe":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image92 = new ImageIcon("WildberryCrepe.PNG");
               recipeImage.setIcon(image92);
               // set ingredientList           
               ingredientList.setText("1. Wildberry\n2. Cane Sugar"
                                       + "\n3. Fresh Milk\n4. Bird Egg"
                                       + "\n5. Tabantha Wheat");
               break;
            case "Egg Tart":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image93 = new ImageIcon("EggTart.PNG");
               recipeImage.setIcon(image93);
               // set ingredientList           
               ingredientList.setText("1. Bird Egg\n2. Goat Butter"
                                       + "\n3. Cane Sugar\n4. Tabantha"
                                       + " Wheat\n5. n/a");
               break;
            case "Egg Pudding":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image94 = new ImageIcon("EggPudding.PNG");
               recipeImage.setIcon(image94);
               // set ingredientList           
               ingredientList.setText("1. Bird Egg\n2. Fresh Milk"
                                       + "\n3. Cane Sugar\n4. n/a\n5. n/a");
               break;
            case "Fried Bananas":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image95 = new ImageIcon("FriedBananas.PNG");
               recipeImage.setIcon(image95);
               // set ingredientList           
               ingredientList.setText("1. Mighty Bananas\n2. Cane Sugar"
                                       + "\n3. Tabantha Wheat\n4. n/a"
                                       + "\n5. n/a");
               break;
            case "Hot Buttered Apple":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image96 = new ImageIcon("HotButteredApple.PNG");
               recipeImage.setIcon(image96);
               // set ingredientList           
               ingredientList.setText("1. Goat Butter\n2. Apple"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Honeyed Apple":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image97 = new ImageIcon("HoneyedApple.PNG");
               recipeImage.setIcon(image97);
               // set ingredientList           
               ingredientList.setText("1. Apple\n2. Courser Bee Honey"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Honeyed Fruits":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image98 = new ImageIcon("HoneyedFruits.PNG");
               recipeImage.setIcon(image98);
               // set ingredientList           
               ingredientList.setText("1. Any fruit excluding apples\n2. Courser"
                                       + " Bee Honey\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Honey Candy":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image99 = new ImageIcon("HoneyCandy.PNG");
               recipeImage.setIcon(image99);
               // set ingredientList           
               ingredientList.setText("1. Courser Bee Honey\n2. n/a"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
               
            // monster foods
            case "Monster Soup":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image100 = new ImageIcon("MonsterSoup.PNG");
               recipeImage.setIcon(image100);
               // set ingredientList           
               ingredientList.setText("1. Monster Extract\n2. Goat Butter"
                                       + "\n3. Fresh Milk\n4. Tabantha"
                                       + " Wheat\n5. n/a");
               break;
            case "Monster Curry":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image101 = new ImageIcon("MonsterCurry.PNG");
               recipeImage.setIcon(image101);
               // set ingredientList           
               ingredientList.setText("1. Monster Extract\n2. Goron Spice"
                                       + "\n3. Hylian Rice\n4. n/a\n5. n/a");
               break;
            case "Monster Rice Balls":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image102 = new ImageIcon("MonsterRiceBalls.PNG");
               recipeImage.setIcon(image102);
               // set ingredientList           
               ingredientList.setText("1. Monster Extract\n2. Hylian Rice"
                                       + "\n3. Rock Salt\n4. n/a\n5. n/a");
               break;
            case "Monster Stew":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image103 = new ImageIcon("MonsterStew.PNG");
               recipeImage.setIcon(image103);
               // set ingredientList           
               ingredientList.setText("1. Monster Extract\n2. Any meat"
                                       + "\n3. Any seafood\n4. n/a\n5. n/a");
               break;
            case "Monster Cake":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image104 = new ImageIcon("MonsterCake.PNG");
               recipeImage.setIcon(image104);
               // set ingredientList           
               ingredientList.setText("1. Monster Extract\n2. Cane Sugar"
                                       + "\n3. Goat Butter\n4. Tabantha"
                                       + " Wheat\n5. n/a");
               break;
               
            // sides and snacks
            case "Sauteed Peppers":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image105 = new ImageIcon("SauteedPeppers.PNG");
               recipeImage.setIcon(image105);
               // set ingredientList           
               ingredientList.setText("1. Spicy Pepper\n2. n/a"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Fairy Tonic":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image106 = new ImageIcon("FairyTonic.PNG");
               recipeImage.setIcon(image106);
               // set ingredientList           
               ingredientList.setText("1. Fairy\n2. Any gem, animal, or"
                                       + " monster part\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Sauteed Nuts":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image107 = new ImageIcon("SauteedNuts.PNG");
               recipeImage.setIcon(image107);
               // set ingredientList           
               ingredientList.setText("1. Any nut\n2. n/a\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Simmered Fruit":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image108 = new ImageIcon("SimmeredFruit.PNG");
               recipeImage.setIcon(image108);
               // set ingredientList           
               ingredientList.setText("1. Any fruit\n2. n/a"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Warm Milk":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image109 = new ImageIcon("WarmMilk.PNG");
               recipeImage.setIcon(image109);
               // set ingredientList           
               ingredientList.setText("1. Fresh Milk\n2. n/a"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Wheat Bread":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image110 = new ImageIcon("WheatBread.PNG");
               recipeImage.setIcon(image110);
               // set ingredientList           
               ingredientList.setText("1. Tabantha Wheat\n2. Rock Salt"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Steamed Fruit":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image111 = new ImageIcon("SteamedFruit.PNG");
               recipeImage.setIcon(image111);
               // set ingredientList           
               ingredientList.setText("1. Any fruit\n2. Any vegetable, herb,"
                                       + " or flower\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Fruit and Mushroom Mix":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image112 = new ImageIcon("FruitAndMushroomMix.PNG");
               recipeImage.setIcon(image112);
               // set ingredientList           
               ingredientList.setText("1. Any fruit\n2. Any mushroom"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Copious Simmered Fruit":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image113 = new ImageIcon("CopiousSimmeredFruit.PNG");
               recipeImage.setIcon(image113);
               // set ingredientList           
               ingredientList.setText("1. Four different fruits\n2. n/a"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Glazed Mushrooms":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image114 = new ImageIcon("GlazedMushrooms.PNG");
               recipeImage.setIcon(image114);
               // set ingredientList           
               ingredientList.setText("1. Any mushroom\n2. Courser Bee Honey"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
            case "Glazed Veggies":
               // set recipeName
               recipeName.setText(myRecipe);
               // set recipeImage
               ImageIcon image115 = new ImageIcon("GlazedVeggies.PNG");
               recipeImage.setIcon(image115);
               // set ingredientList           
               ingredientList.setText("1. Any vegetable\n2. Courser Bee Honey"
                                       + "\n3. n/a\n4. n/a\n5. n/a");
               break;
         }
      }
   }

   // the main method
   public static void main(String[] args) {
      // invoke the ZeldaRecipeGUI constructor
      ZeldaRecipeGenerator zeldaRecipeGUI = new ZeldaRecipeGenerator();  
   }
}