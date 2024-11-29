import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Scanner scanner1 = new Scanner(System.in);

    // Take Input Method (for integers)
    static int takeInput() {
        return scanner1.nextInt();
    }

    // Story Prologue as Method
    static void Prologue() throws InterruptedException {
        System.out.println("It's the year 2077.");
        //TimeUnit.MILLISECONDS.sleep(1700); // Breaks in between Prologue Lines
        System.out.println("You're walking to your usual minimum wage IT job.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("You thought it would be a good idea when you we're little.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("But the market crashed and now it's no more than a slave's job.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("You hate your life , you just wanna end it.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("Luckily for you , a random anvil falls on your head and the death is instant.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("You are now face to face with the Almighty God Himself.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("You thought it would've been paradise. But you we're sent to the deepest pits of Hell.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("You find a sword sculpted from bones. You think that's convenient.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("You encounter a strange face. He introduces himself as Ajax.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("Ajax : What's your name ? Let's get this adventure started already this prologue was hellishly long.\n");
    }

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        Stats p1 = new Stats();
        p1.level = 0;
        p1.HP = 20;
        p1.hpCap = 20;
        Stats mon = new Stats();
        mon.HP = 15;
        int slashAttackBound = 5;
        int boopAttackBound = 3;
        int attackDamage;
        int coinsAmount = 0;
        int medKitAmount = 0;
        int oreoCookieAmount = 0;
        int runeOfDemonsAmount = 0;
        int scrapMetalAmount = 0;
        Boolean swordOfFieryPits = false;
        Boolean reinforcedMiddleFinger = false;
        boolean manual = false;
        int playerEXP = 0;
        int levelEXP = 10;

        Prologue();
        System.out.print("Enter Username: ");
        String pName = scanner1.nextLine();
        p1.name = pName;
        System.out.println("Ajax : Alright " + p1.name + ", let's go.");
        System.out.println("End Of Prologue-------------------------\n");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("=TUTORIAL=");
        System.out.println("-You start with 20HP, Level 0 and 0 Coins;");
        System.out.println("-Every Level you can upgrade attacks and become stronger; ");
        System.out.println("-Inputs are mainly done through numbers; ");
        System.out.println("-Purchase Potions and Items from the Vendor nearby to get stronger; ");
        System.out.println("-You can get Drops from Monsters and use them at BlackSmith : ");
        System.out.println("* 1% Chance Drop : Rune Of Demons; ");
        System.out.println("* 25% Chance Drop : Scrap Metal; ");
        System.out.println("-Monster Difficulty should rise with every Level, good luck out there. \n");
        //TimeUnit.MILLISECONDS.sleep(2000);
        while (p1.HP > 0) {
            System.out.println("Choose where you want to go / what you want to do. (Input Number)");
            System.out.println("[1].Ahead to the fight;");
            System.out.println("[2].To the Blacksmith's workplace;");
            System.out.println("[3].To the Vendor's Shop;");
            System.out.println("[4].Player Stats/Player Inventory;");
            // TODO : modern switch cases
            switch (takeInput()) {
                case 1:
                    // case 1 = enemy encounter
                    int randomEnemy = rand.nextInt(4);
                    // Enemy Type chosen at random
                    switch (randomEnemy) {
                        case 0:
                            mon.name = "Opal";
                            mon.attackOne = "Scratch";
                            mon.attackTwo = "Linux Binary Attack";
                            break;
                        case 1:
                            mon.name = "Emica";
                            mon.attackOne = "Power Chord";
                            mon.attackTwo = "Hurtful Musical Notes";
                            break;
                        case 2:
                            mon.name = "Swift";
                            mon.attackOne = "Speed Of Light";
                            mon.attackTwo = "Rapid Clones";
                            break;
                        case 3:
                            mon.name = "Mark The Impaler";
                            mon.attackOne = "The Strike Of Compressed Idiocy";
                            mon.attackTwo = "Weaponized Ambivalence";
                            break;
                        default:
                    }
                    System.out.println("You encountered " + mon.name + "!");
                    while (p1.HP >= 0 && mon.HP >= 0) {
                        int randomBattleQuote = rand.nextInt(5);
                        // random quote
                        switch (randomBattleQuote) {
                            case 0:
                                System.out.println("You feel a shiver down your spine.\n");
                                break;
                            case 1:
                                System.out.println("While scared, you manage to gather some courage for your next action.\n");
                                break;
                            case 2:
                                System.out.println("Determination is all you need, no ?\n");
                                break;
                            case 3:
                                System.out.println("TIP: 'Slash' has a chance at a critical hit for double damage!\n");
                                break;
                            case 4:
                                System.out.println("TIP: 'Boop' has will always do " + boopAttackBound + " damage.");
                                break;
                            default:
                        }
                        System.out.println("[1].Slash;");
                        System.out.println("[2].Boop;");
                        System.out.println("[3].Inventory");
                        System.out.print("Select thy action (number input) :");
                        // TODO : figure out exceptions in inputs
                        // switch cases based on action picked (in battle)
                        switch (takeInput()) {
                            // slash case
                            case 1:
                                attackDamage = rand.nextInt(slashAttackBound) + 1;
                                System.out.println(p1.name + " used 'Slash'!");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                int slashRngCRIT = rand.nextInt(3);
                                if (slashRngCRIT == 2) {
                                    attackDamage = attackDamage * 2;
                                    System.out.println("It was Citical Hit for Double Damage!!");
                                }
                                System.out.println(p1.name + " hit " + mon.name + " for " + attackDamage + " damage!");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                mon.HP -= attackDamage;
                                // TODO : Conditions to make monster NOT fight back if it's dead
                                System.out.println(mon.name + " is preparing an attack...\n");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                int monsterRNG = rand.nextInt(7) + 1;
                                int monsRandAttack = rand.nextInt(2);
                                switch (monsRandAttack) {
                                    case 0:
                                        System.out.println(mon.name + " used " + mon.attackOne + " to deal " + monsterRNG + " damage!\n");
                                        break;
                                    case 1:
                                        System.out.println(mon.name + " used " + mon.attackTwo + " to deal " + monsterRNG + " damage!\n");
                                        break;
                                    default:
                                }
                                p1.HP -= monsterRNG;
                                System.out.println(p1.name + " is now at " + p1.HP + " HP remaining.");
                                System.out.println(mon.name + " is now at " + mon.HP + " HP remaining.\n");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                break;
                            // boop case
                            case 2:
                                System.out.println(p1.name + " used 'Boop'!");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                System.out.println(p1.name + " hit " + mon.name + " for 3 damage!");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                mon.HP -= boopAttackBound;
                                System.out.println(mon.name + " is preparing an attack...\n");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                monsterRNG = rand.nextInt(7) + 1;
                                monsRandAttack = rand.nextInt(2);
                                switch (monsRandAttack) {
                                    case 0:
                                        System.out.println(mon.name + " used " + mon.attackOne + " to deal " + monsterRNG + " damage!\n");
                                        break;
                                    case 1:
                                        System.out.println(mon.name + " used " + mon.attackTwo + " to deal " + monsterRNG + " damage!\n");
                                        break;
                                    default:
                                }
                                p1.HP -= monsterRNG;
                                System.out.println(p1.name + " is now at " + p1.HP + " HP remaining.");
                                System.out.println(mon.name + " is now at " + mon.HP + " HP remaining.\n");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                break;
                            case 3:
                                // inventory case
                                System.out.println("\nYou took a peek in your inventory.");
                                System.out.println("---------------------------------");
                                System.out.println("[1].Medkit, Heal 10 HP (Note: Capped at MaxHP=" + p1.hpCap + "). (you have " + medKitAmount + " MedKits)");
                                System.out.println("[2].Oreo Cookie, weaken next Enemy Attack by -4 BUT your next attack can only do up to 3 Damage. (you have " + oreoCookieAmount + " Oreo Cookies)");
                                System.out.println("[Invalid Input].Go back to Main Fighting Menu.");
                                System.out.print("Use Item / Input (number): ");
                                // check for items and see if player can use them
                                switch (takeInput()) {
                                    // medkit
                                    case 1:
                                        if (medKitAmount > 0) {
                                            System.out.println("Used Medkit for +10HP.");
                                            p1.HP += 10;
                                            if (p1.HP > p1.hpCap) {
                                                int hpCAP = p1.HP - p1.hpCap;
                                                p1.HP -= hpCAP;
                                            }
                                            System.out.println("You are now at " + p1.HP + " HP. (-1 MedKit)\n");
                                            medKitAmount--;
                                            TimeUnit.MILLISECONDS.sleep(1400);
                                            System.out.println(mon.name + " is preparing an attack...\n");
                                            TimeUnit.MILLISECONDS.sleep(1700);
                                            monsterRNG = rand.nextInt(7) + 1;
                                            monsRandAttack = rand.nextInt(2);
                                            switch (monsRandAttack) {
                                                case 0:
                                                    System.out.println(mon.name + " used " + mon.attackOne + " to deal " + monsterRNG + " damage!\n");
                                                    break;
                                                case 1:
                                                    System.out.println(mon.name + " used " + mon.attackTwo + " to deal " + monsterRNG + " damage!\n");
                                                    break;
                                                default:
                                            }
                                            p1.HP -= monsterRNG;
                                            System.out.println(p1.name + " is now at " + p1.HP + " HP remaining.");
                                            System.out.println(mon.name + " is now at " + mon.HP + " HP remaining.\n");
                                            TimeUnit.MILLISECONDS.sleep(1700);
                                            break;
                                        } else if (medKitAmount <= 0) {
                                            System.out.println("\nNot enough MedKits to heal.");
                                            TimeUnit.MILLISECONDS.sleep(1000);
                                            break;
                                        }
                                        break;
                                    // oreo cookie
                                    case 2:
                                        // TODO : Level System/Level Cap System/HP Cap System
                                        // TODO : Add Khaj to the game
                                        // TODO : comment out more code
                                        if (oreoCookieAmount > 0) {
                                            oreoCookieAmount--;
                                            System.out.println("Used Oreo Cookie for -4 damage on next Monster Attack.");
                                            System.out.println("You are preparing a debuffed attack yourself...");
                                            TimeUnit.MILLISECONDS.sleep(1600);
                                            int debuffedOreoAttack = rand.nextInt(3) + 1;
                                            System.out.println("You hit " + mon.name + " for " + debuffedOreoAttack + "HP !");
                                            System.out.println(mon.name + " is preparing an attack...\n");
                                            TimeUnit.MILLISECONDS.sleep(1700);
                                            monsterRNG = rand.nextInt(7) + 1;
                                            monsterRNG -= 4;
                                            if (monsterRNG <= 0) {
                                                monsterRNG = 0;
                                            }
                                            monsRandAttack = rand.nextInt(2);
                                            switch (monsRandAttack) {
                                                case 0:
                                                    System.out.println(mon.name + " used " + mon.attackOne + " to deal " + monsterRNG + " damage! (Oreo Cookie Debuff Active)\n");
                                                    break;
                                                case 1:
                                                    System.out.println(mon.name + " used " + mon.attackTwo + " to deal " + monsterRNG + " damage! (Oreo Cookie Debuff Active)\n");
                                                    break;
                                                default:
                                            }
                                            p1.HP -= monsterRNG;
                                            System.out.println(p1.name + " is now at " + p1.HP + " HP remaining.");
                                            System.out.println(mon.name + " is now at " + mon.HP + " HP remaining.\n");
                                            TimeUnit.MILLISECONDS.sleep(1700);
                                        } else if (oreoCookieAmount <= 0) {
                                            System.out.println("\nNo Oreo Cookies in Inventory.");
                                            TimeUnit.MILLISECONDS.sleep(1000);
                                            break;
                                        }
                                        break;
                                }
                            default:
                        }
                        if (mon.HP <= 0) {
                            System.out.println(mon.name + " defeated!");
                            TimeUnit.MILLISECONDS.sleep(1000);
                            int randCoins = rand.nextInt(15) + 1;
                            System.out.println("Obtained " + randCoins + " Coins!");
                            coinsAmount += randCoins;
                            TimeUnit.MILLISECONDS.sleep(1000);
                            int randRune = rand.nextInt(100);
                            if (randRune == 99) {
                                System.out.println("RUNE OF DEMONS OBTAINED.");
                                TimeUnit.MILLISECONDS.sleep(1000);
                                runeOfDemonsAmount++;
                            }
                            int randScrap = rand.nextInt(4);
                            if (randScrap == 3) {
                                System.out.println("+1 Scrap Metal!");
                                TimeUnit.MILLISECONDS.sleep(1000);
                                scrapMetalAmount++;
                            }
                            TimeUnit.MILLISECONDS.sleep(1000);
                            System.out.println("---------------------");
                        }
                    }
                    break;
                // blacksmith
                case 2:
                    System.out.println("You arrive at the Forgery and meet 'Whoami' the BlackSmith , who greets you kindly :");
                    TimeUnit.MILLISECONDS.sleep(1700);
                    System.out.println("Whoami : Here you can refine your items and attacks. I need materials and your money!");
                    TimeUnit.MILLISECONDS.sleep(1700);
                    System.out.println("[1]. Upgrade Bone Sword -> Sword Of Fiery Pits;");
                    System.out.println("[2]. Normal Middle Finger -> Reinforced Middle Finger;");
                    System.out.println("[Invalid Input]. Leave Blacksmith;");
                    switch (takeInput()) {
                        // TODO : change 'slash' attack damage if sword of fiery pits is crafted
                        case 1:
                            System.out.println("\n-Sword Of Fiery Pits-");
                            System.out.println("---------------------------");
                            System.out.println("<A Sword forged from Hell's most scorching fires and most Frightful Screams.>");
                            System.out.println("<'Slash' Attack Damage +5000,become Unkillable, The Reaper, The Ultimate Terror of HELL.>");
                            System.out.println("---------------------------");
                            System.out.println("* (x1) Rune of Demons;");
                            System.out.println("* 100 Coins;\n");
                            TimeUnit.MILLISECONDS.sleep(1500);
                            System.out.println("Whoami : Wanna craft this bad boy?");
                            TimeUnit.MILLISECONDS.sleep(1500);
                            System.out.println("[1].Yes;");
                            System.out.println("[2].No;");
                            System.out.println("[Invalid Input]. Leave Blacksmith;");
                            switch (takeInput()) {
                                case 1:
                                    if (runeOfDemonsAmount > 0 && coinsAmount >= 100) {
                                        swordOfFieryPits = true;
                                        System.out.println("Crafted SWORD OF FIERY PITS. (+5000 Damage on 'Slash' Attack)");
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    } else if (runeOfDemonsAmount <= 0 || coinsAmount <= 100) {
                                        System.out.println("Whoami : Not enough Coins/Materials;");
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    }
                                    break;
                                case 2:
                                    System.out.println("You chose not to craft the Sword.");
                                    TimeUnit.MILLISECONDS.sleep(1000);
                                    break;
                                default:
                            }
                            break;
                        // TODO : reinforced middle finger
                        case 2:
                            System.out.println("\n-Reinforced Middle Finger-");
                            System.out.println("---------------------------");
                            System.out.println("<Boop your enemies harder than ever before.>");
                            System.out.println("<+10 Damage on 'Boop' Attack>");
                            System.out.println("---------------------------");
                            System.out.println("* (x3) Metal Scrap Pieces;");
                            System.out.println("* 35 Coins;\n");
                            TimeUnit.MILLISECONDS.sleep(1500);
                            System.out.println("Whoami : Ready for an Upgrade?");
                            System.out.println("[1].Yes;");
                            System.out.println("[2].No;");
                            System.out.println("[Invalid Input]. Leave Blacksmith;");
                    }
                    break;
                // vendor
                case 3:
                    System.out.println("You arrived at the Vendor. Encountered 'Sauce The Vendor'. ");
                    System.out.println("Sauce : Pick a item to buy or get out of my store already.");
                    TimeUnit.MILLISECONDS.sleep(1500);
                    System.out.println("------------------------------------------");
                    System.out.println("Sauce's Shop || You have " + coinsAmount + " coins.");
                    System.out.println("------------------------------------------");
                    System.out.println("[1].MedKit (Heals 10 HP); || 10 COINS");
                    System.out.println("[2].Oreo Cookie (Take 4 less Damage on next Monster Attack); || 15 COINS");
                    System.out.println("[3].Manual of Bodily Health (Increases Player Overall HP by +5) || 50 COINS");
                    System.out.println("[Invalid Input].Leave Store");
                    // user item purchasing
                    switch (takeInput()) {
                        case 1:
                            if (coinsAmount >= 10) {
                                medKitAmount++;
                                coinsAmount -= 10;
                                System.out.println("You bought a MedKit for 10 coins.");
                                System.out.println("You now have " + coinsAmount + " coins left and " + medKitAmount + " MedKits.");
                            } else {
                                System.out.println("Sauce : Trying to steal moron? GET THE FUCK OUT!!");
                                TimeUnit.MILLISECONDS.sleep(2000);
                                System.out.println("You got kicked out for trying to steal.\n");
                                break;
                            }
                            break;
                        case 2:
                            if (coinsAmount >= 15) {
                                oreoCookieAmount++;
                                coinsAmount -= 15;
                            } else {
                                System.out.println("Sauce : That hungry for a cookie? Get out!");
                                TimeUnit.MILLISECONDS.sleep(2000);
                                System.out.println("You got kicked out for trying to steal.\n");
                                break;
                            }
                            break;
                        case 3:
                            if (coinsAmount >= 50) {
                                p1.hpCap += 5;
                                System.out.println("You now have " + p1.hpCap + " HP Limit. (+5 from Manual Of Bodily Health)\n");
                                coinsAmount -= 50;
                                TimeUnit.MILLISECONDS.sleep(1500);
                            } else {
                                System.out.println("Sauce : The Manual's a rare relic. Can't let you have that for free.");
                                TimeUnit.MILLISECONDS.sleep(2000);
                                System.out.println("You got kicked out for trying to steal.\n");
                                break;
                            }
                            break;
                        default:
                            System.out.println("You left the store. ");
                            break;
                    }
                    break;
                // player stats
                case 4:
                    System.out.println("-STATS-");
                    System.out.printf("* Name: %s%n", p1.name);
                    System.out.printf("* Level: %d, %d/%d EXP%n", p1.level, playerEXP, levelEXP);
                    System.out.printf("* Max HP : %d%n", p1.hpCap);
                    System.out.printf("* Current HP : %d%n", p1.HP);
                    System.out.println("-INVENTORY-");
                    System.out.printf("* %d MedKits%n", medKitAmount);
                    System.out.printf("* %d Oreo Cookies\n%n", oreoCookieAmount);
                    TimeUnit.MILLISECONDS.sleep(2000);
                    break;

                default:
                    System.out.print("Please input valid number: ");
                    break;
            }
            // end menu if player HP <0
            if (p1.HP <= 0) {
                System.out.println("--------------------------------------");
                System.out.println("It all goes pitch black all of a sudden.");
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println("A scary and tall figure introduces himself as Bench The Reality Bender.");
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println("Bench : You died. You shall now face eternal suffering , not just in Hell but also within this realm of Darkness.");
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println("-STATS-");
                TimeUnit.MILLISECONDS.sleep(1500);
                System.out.println("* name : " + p1.name);
                System.out.println("* Level: " + p1.level);
                System.out.println("* Max HP: " + p1.hpCap);
            }
        }
    }
}