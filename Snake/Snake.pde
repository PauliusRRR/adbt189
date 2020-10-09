PFont myFont;
PFont myFont1;
int sizeWidth=40;
int sizeHeight=40;
int construct=20;
int path=2;
int foodPosx=15;
int foodPosy=15;
int snakeSpeed = 6;
int[]x_direction={0, 0, 1, -1}; 
int[]y_direction={1, -1, 0, 0}; 
boolean gameover=false;
ArrayList<Integer> x = new ArrayList<Integer>(); 
ArrayList<Integer> y = new ArrayList<Integer>(); 

void setup() { 
  //Size and Snake position
  size(800, 800); 
  x.add(20); 
  y.add(20);
}   
void draw() 
{  
  background(#CECE62);
  fill(#6C0A6B); 
  for (int i = 0; i < x.size(); i++) rect(x.get(i)*construct, y.get(i)*construct, construct, construct);
    if (!gameover) 
  {  
    foodFunction();
    score();
    if (frameCount%snakeSpeed==0) 
    { 
      snakeFunction();
      foodRespawn();
    }
  } else {
    gameOver();
  }
}

void keyPressed() { 
  int newDirection=keyCode == DOWN? 0:(keyCode == UP?1:(keyCode == RIGHT?2:(keyCode == LEFT?3:-1)));
  if (newDirection != -1) 
  path = newDirection;
}

void foodFunction() {
  fill(random(255),random(255),random(255));
  ellipse(foodPosx*construct+10, foodPosy*construct+10, construct, construct);
}

void foodRespawn() {
  if (x.get(0)==foodPosx && y.get(0)==foodPosy) 
  { //new food if we touch
    if (x.size() %6==0 && snakeSpeed>=3) 
    snakeSpeed-=1;  
    foodPosx = (int)random(0, sizeWidth); 
    foodPosy = (int)random(0, sizeHeight);
  } else 
  { 
    x.remove(x.size()-1); 
    y.remove(y.size()-1);
  }
}

void snakeFunction() {
  x.add(0, x.get(0) + x_direction[path]); 
  y.add(0, y.get(0) + y_direction[path]);
  if (x.get(0) < 0 || y.get(0) < 0 || x.get(0) >= sizeWidth || y.get(0) >= sizeHeight) gameover = true; //If snake is outside of the given size gameover is true
  for (int i=1; i<x.size(); i++) 
    if (x.get(0)==x.get(i)&&y.get(0)==y.get(i)) 
    gameover=true;
}

void gameOver() {
  fill(255); 
  myFont1=createFont("Tw Cen MT Condensed", 180);
  textFont(myFont1);
  textAlign(CENTER); 
  text("GAME OVER \n", 410, 325);
  myFont1=createFont("Tw Cen MT Condensed", 50);
  textFont(myFont1);
  textAlign(CENTER); 
  text("SCORE: "+ x.size() +"\n TO RESTART PRESS ENTER KEY", 400, 400);
  if (keyCode == ENTER) { 
    x.clear(); 
    y.clear(); 
    x.add(20);  
    y.add(20);
    path = 2;
    snakeSpeed = 6;
    gameover = false;
  }
}

void score() {
  myFont = createFont("Trebuchet MS Bold", 25);
  textFont(myFont);
  textAlign(CENTER);
  fill(255);
  text("Score: " + x.size(), 10, 10, width - 20, 50);
}
