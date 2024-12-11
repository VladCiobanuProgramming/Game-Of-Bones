// If you're reading this as a player i suggest looking at the code and uncommenting the TimeUnits, then play for better experience
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/*
TODO list
- figure out exceptions in inputs
- rebuild code aka better structure
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    // Take Input Method (for integers)
    static int takeInput() {
        return scanner.nextInt();
    }
    // Story Prologue as Method
    static void Prologue() throws InterruptedException {
        System.out.println("It's the year 2077.");
        //TimeUnit.MILLISECONDS.sleep(1700); // Breaks in between Prologue Lines
        System.out.println("You're walking to your usual minimum wage IT job.");
        //TimeUnit.MILLISECONDS.sleep(1700);
        System.out.println("You thought it would be a good idea when you were little.");
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
        System.out.println("Ajax : Have this Medkit to help you in your adventure. What's your name though ? (+1 MedKit from Ajax)\n");
    }

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        Stats player = new Stats();
        player.level = 0;
        player.HP = 20;
        player.hpCap = 20;
        Stats monster = new Stats();
        monster.hpCap = 15;
        int monsterRNGBound = 7;
        int slashAttackBound = 5;
        int boopAttackBound = 3;
        int attackDamage;
        int coinsAmount = 0;
        int medKitAmount = 1;
        int oreoCookieAmount = 0;
        int runeOfDemonsAmount = 0;
        int scrapMetalAmount = 0;
        int playerEXP = 0;
        int levelEXP = 10;
        boolean swordOfFieryPits = false;
        boolean reinforcedMiddleFinger = false;

        Prologue();
        System.out.print("Enter Username: ");
        String pName = scanner.nextLine();
        player.name = pName;

        System.out.println("Ajax : Alright " + player.name + ", let's go.");
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

        while (player.HP > 0) {
            System.out.println("Choose where you want to go / what you want to do. (Input Number)");
            System.out.println("[1].Ahead to the fight;");
            System.out.println("[2].To the Blacksmith's workplace;");
            System.out.println("[3].To the Vendor's Shop;");
            System.out.println("[4].Player Stats/Player Inventory;");
            switch (takeInput()) {
                case 1:
                    // case 1 = enemy encounter
                    monster.HP=monster.hpCap;
                    // enemy type chosen at random
                    Monsters currentMonster = null;
                    switch (rand.nextInt(4)) {
                        case 0 -> currentMonster = Monsters.OPAL;

                        case 1 -> currentMonster = Monsters.EMICA;

                        case 2 -> currentMonster = Monsters.SWIFT;

                        case 3 -> currentMonster = Monsters.MARK_THE_IMPALER;
                    }
                    // battle starts
                    System.out.println("You encountered " + currentMonster.name + "!");

                    while (player.HP >= 0 && monster.HP >= 0) {
                        int randomBattleQuote = rand.nextInt(5);
                        // random quote displayed after turns
                        switch (randomBattleQuote) {
                            case 0 -> System.out.println("You feel a shiver down your spine.\n");

                            case 1 -> System.out.println("While scared, you manage to gather some courage for your next action.\n");

                            case 2 -> System.out.println("Determination is all you need, no ?\n");

                            case 3 -> System.out.println("TIP: 'Slash' has a chance at a critical hit for double damage!\n");

                            case 4 -> System.out.println("TIP: 'Boop' has will always do " + boopAttackBound + " damage.");
                        }
                        // Player turn choices
                        System.out.println("[1].Slash;");
                        System.out.println("[2].Boop;");
                        System.out.println("[3].Inventory");
                        System.out.print("Select thy action (number input) :");
                        switch (takeInput()) {
                            //  case 1 : slash attack case
                            case 1:
                                // Damage monster will do in its turn
                                int monsterRNG = rand.nextInt(monsterRNGBound) + 1;
                                // Variable value 0 or 1 to help pick the monster used attack at random
                                int monsRandAttack = rand.nextInt(2);
                                /* Player attack damage will range from 1 to slashAttackBound (which can increase if player obtains upgrades)
                                   slashAttackBound starts from 5 => Player attack damage can do up to 5 damage
                                 */
                                attackDamage = rand.nextInt(slashAttackBound) + 1;
                                // condition if sword of fiery pits is crated
                                if (swordOfFieryPits) {
                                    attackDamage += 5000;
                                }
                                System.out.println(player.name + " used 'Slash'!");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                // crit chance
                                int slashRngCRIT = rand.nextInt(3);
                                // if crit chance is hit <=> slashRngCRIT == 2
                                if (slashRngCRIT == 2) {
                                    // attackDamage doubles
                                    attackDamage = attackDamage * 2;
                                    System.out.println("It was Citical Hit for Double Damage!!");
                                }
                                System.out.println(player.name + " hit " + currentMonster.name + " for " + attackDamage + " damage!");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                monster.HP -= attackDamage;
                                // check for monster >0 to make sure it doesn't attack while dead
                                if (monster.HP > 0) {
                                    System.out.println(currentMonster.name + " is preparing an attack...\n");
                                    TimeUnit.MILLISECONDS.sleep(1700);
                                    switch (monsRandAttack) {
                                        case 0 -> System.out.println(currentMonster.name + " used " + currentMonster.attack1 + " to deal " + monsterRNG + " damage!\n");

                                        case 1 -> System.out.println(currentMonster.name + " used " + currentMonster.attack2 + " to deal " + monsterRNG + " damage!\n");
                                    }
                                    player.HP -= monsterRNG;
                                    // aftermath of turns
                                    System.out.println(player.name + " is now at " + player.HP + " HP remaining.");
                                    System.out.println(currentMonster.name + " is now at " + monster.HP + " HP remaining.\n");
                                    TimeUnit.MILLISECONDS.sleep(1700);
                                }
                                break;

                            // case 2 : boop attack case
                            case 2:
                                System.out.println(player.name + " used 'Boop'!");
                                // condition if reinforced middle finger is crafted
                                if (reinforcedMiddleFinger) {
                                    boopAttackBound += 5;
                                }
                                TimeUnit.MILLISECONDS.sleep(1700);
                                System.out.println(player.name + " hit " + currentMonster.name + " for " + boopAttackBound + " damage!");
                                TimeUnit.MILLISECONDS.sleep(1700);
                                // boop attack will always do a set damage , the starting damage is 3 ( can vary if player upgrades stats)
                                monster.HP -= boopAttackBound;
                                // check for monster >0 to make sure it doesn't attack while dead
                                if (monster.HP > 0) {
                                    System.out.println(currentMonster.name + " is preparing an attack...\n");
                                    TimeUnit.MILLISECONDS.sleep(1700);
                                    monsterRNG = rand.nextInt(7) + 1;
                                    monsRandAttack = rand.nextInt(2);
                                    switch (monsRandAttack) {
                                        case 0 -> System.out.println(currentMonster.name + " used " + currentMonster.attack1 + " to deal " + monsterRNG + " damage!\n");

                                        case 1 -> System.out.println(currentMonster.name + " used " + currentMonster.attack2 + " to deal " + monsterRNG + " damage!\n");

                                    }
                                    // aftermath of turns
                                    player.HP -= monsterRNG;
                                    System.out.println(player.name + " is now at " + player.HP + " HP remaining.");
                                    System.out.println(currentMonster.name + " is now at " + monster.HP + " HP remaining.\n");
                                    TimeUnit.MILLISECONDS.sleep(1700);
                                }
                                break;

                            case 3:
                                // case 3 : inventory case
                                System.out.println("\nYou took a peek in your inventory.");
                                System.out.println("-".repeat(45));
                                System.out.println("[1].Medkit, Heal 10 HP (Note: Capped at MaxHP=" + player.hpCap + "). (you have " + medKitAmount + " MedKits)");
                                System.out.println("[2].Oreo Cookie, weaken next Enemy Attack by -4 BUT your next attack can only do up to 3 Damage. (you have " + oreoCookieAmount + " Oreo Cookies)");
                                System.out.println("[Invalid Input].Go back to Main Fighting Menu.");
                                System.out.print("Use Item / Input (number): ");

                                switch (takeInput()) {
                                    // case 1 : medkit
                                    case 1:
                                        // use medkit if medKitAmount in player inventory >0
                                        if (medKitAmount > 0) {
                                            System.out.println("Used Medkit for +10HP.");
                                            player.HP += 10;
                                            // cap the healing at hp Capacity so it can't go beyond it
                                            if (player.HP > player.hpCap) {
                                                int hpCAP = player.HP - player.hpCap;
                                                player.HP -= hpCAP;
                                            }
                                            System.out.println("You are now at " + player.HP + " HP. (-1 MedKit)\n");
                                            medKitAmount--;
                                            // check for monster >0 to make sure it doesn't attack while dead
                                            if (monster.HP > 0) {
                                                TimeUnit.MILLISECONDS.sleep(1400);
                                                System.out.println(currentMonster.name + " is preparing an attack...\n");
                                                TimeUnit.MILLISECONDS.sleep(1700);
                                                monsterRNG = rand.nextInt(7) + 1;
                                                monsRandAttack = rand.nextInt(2);
                                                switch (monsRandAttack) {
                                                    case 0 -> System.out.println(currentMonster.name + " used " + currentMonster.attack1 + " to deal " + monsterRNG + " damage!\n");

                                                    case 1 -> System.out.println(currentMonster.name + " used " + currentMonster.attack2 + " to deal " + monsterRNG + " damage!\n");
                                                }
                                                player.HP -= monsterRNG;
                                                System.out.println(player.name + " is now at " + player.HP + " HP remaining.");
                                                System.out.println(currentMonster.name + " is now at " + monster.HP + " HP remaining.\n");
                                                TimeUnit.MILLISECONDS.sleep(1700);
                                            }
                                            break;
                                            // else if player does not have enough medkits
                                        } else if (medKitAmount <= 0) {
                                            System.out.println("\nNot enough MedKits to heal.");
                                            TimeUnit.MILLISECONDS.sleep(1000);
                                            break;
                                        }
                                        break;

                                    // case 2 : oreo cookie
                                    case 2:
                                        // TODO : Level System/Level Cap System/HP Cap System
                                        // use oreo cookie if oreoCookieAmount in inventory >0
                                        if (oreoCookieAmount > 0) {
                                            oreoCookieAmount--;
                                            /*
                                            Oreo Cookie makes the next monster attack be weakened by -4 Damage
                                            The only downside is that you yourself can only do up to 3 damage (debuffedOreoAttack = rand.nextInt(3)+1;
                                             */
                                            System.out.println("Used Oreo Cookie for -4 damage on next Monster Attack.");
                                            System.out.println("You are preparing a debuffed attack yourself...");
                                            TimeUnit.MILLISECONDS.sleep(1600);
                                            int debuffedOreoAttack = rand.nextInt(3) + 1;
                                            monster.HP -= debuffedOreoAttack;
                                            System.out.println("You hit " + currentMonster.name + " for " + debuffedOreoAttack + "HP !\n");
                                            TimeUnit.MILLISECONDS.sleep(1600);
                                            if (monster.HP > 0) {
                                                System.out.println(currentMonster.name + " is preparing an attack...\n");
                                                TimeUnit.MILLISECONDS.sleep(1700);
                                                monsterRNG = rand.nextInt(7) + 1;
                                                monsterRNG -= 4;
                                                // check for monsterRng <=0 so that it can't be a Negative Number
                                                if (monsterRNG <= 0) {
                                                    monsterRNG = 0;
                                                }
                                                monsRandAttack = rand.nextInt(2);
                                                switch (monsRandAttack) {
                                                    case 0 -> System.out.println(currentMonster.name + " used " + currentMonster.attack1 + " to deal " + monsterRNG + " damage! (Oreo Cookie Debuff Active)\n");

                                                    case 1 -> System.out.println(currentMonster.name + " used " + currentMonster.attack2 + " to deal " + monsterRNG + " damage! (Oreo Cookie Debuff Active)\n");
                                                }
                                                // aftermath of turns
                                                player.HP -= monsterRNG;
                                                System.out.println(player.name + " is now at " + player.HP + " HP remaining.");
                                                System.out.println(currentMonster.name + " is now at " + monster.HP + " HP remaining.\n");
                                                TimeUnit.MILLISECONDS.sleep(1700);
                                            }
                                            // else if player doesn't have Oreo Cookie(s)
                                        } else if (oreoCookieAmount <= 0) {
                                            System.out.println("\nNo Oreo Cookies in Inventory.");
                                            TimeUnit.MILLISECONDS.sleep(1000);
                                            break;
                                        }
                                        break;
                                }

                            default:
                        }
                        // monster death aftermath
                        if (monster.HP <= 0) {
                            System.out.println(currentMonster.name + " defeated!");
                            TimeUnit.MILLISECONDS.sleep(1000);
                            // random chance material dropping for crafting
                            if (rand.nextInt(100) == 99) {
                                System.out.println("RUNE OF DEMONS OBTAINED. (+1 Rune Of Demons)");
                                TimeUnit.MILLISECONDS.sleep(1000);
                                runeOfDemonsAmount++;
                            }
                            if (rand.nextInt(4) == 3) {
                                System.out.println("+1 Scrap Metal!");
                                TimeUnit.MILLISECONDS.sleep(1000);
                                scrapMetalAmount++;
                            }
                            TimeUnit.MILLISECONDS.sleep(1000);
                            int randCoins = rand.nextInt(15) + 1;
                            System.out.println("Obtained " + randCoins + " Coins!");
                            coinsAmount += randCoins;
                            TimeUnit.MILLISECONDS.sleep(1000);
                            int randExp = rand.nextInt(10) + 1;
                            playerEXP += randExp;
                            System.out.println("+" + randExp + " EXP.");
                            TimeUnit.MILLISECONDS.sleep(1000);
                            // TODO : Figure out how to manage invalid inputs

                            // check for player exp higher or equal to the exp required to level up
                            if (playerEXP >= levelEXP) {
                                System.out.println("Leveled up! (+3 MaxHP !!)");
                                TimeUnit.MILLISECONDS.sleep(1000);
                                System.out.println("Pick and Attack to Upgrade :");
                                TimeUnit.MILLISECONDS.sleep(1000);
                                // user attack upgrade pick
                                System.out.println("[1].Refine Sword (+3 Attack Bound on 'Slash' Attack);");
                                System.out.println("[2].Train Middle Finger (+4 Attack Bound on 'Boop' Attack);");
                                System.out.print("Input: ");
                                switch (takeInput()) {
                                    // case 1 : sword upgrade
                                    case 1 -> {
                                        System.out.println("Sword Upgraded.");
                                        slashAttackBound += 3;
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    }
                                    // case 2 : finger upgrade
                                    case 2 -> {
                                        System.out.println("Finger trained and stronger.");
                                        boopAttackBound += 4;
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    }
                                }
                                System.out.println("Note : Monsters got stronger. Be aware. (+5HP Capacity on Monsters, +2 Attack Bound Range.)\n");
                                TimeUnit.MILLISECONDS.sleep(1500);
                                // increase monster/player HP, possible attack damage, reset player EXP points and increase level required to level up again
                                player.hpCap += 3;
                                monster.hpCap +=5;
                                monsterRNGBound += 2;
                                playerEXP = 0;
                                levelEXP += 5;
                                monsterRNGBound += 2;
                                player.level++;
                                monster.HP = monster.hpCap;
                                player.HP = player.hpCap;
                            }
                            System.out.println("---------------------");
                            break;
                        }
                        // player death aftermath
                        if (player.HP <= 0) {
                            System.out.println("-".repeat(45));
                            System.out.println("It all goes pitch black all of a sudden.");
                            TimeUnit.MILLISECONDS.sleep(2000);
                            System.out.println("A scary and tall figure introduces himself as Bench The Reality Bender.");
                            TimeUnit.MILLISECONDS.sleep(2000);
                            System.out.println("Bench : You died. You shall now face eternal suffering , not just in Hell but also within this realm of Darkness.");
                            TimeUnit.MILLISECONDS.sleep(2000);
                            // player stats display
                            System.out.println("-STATS-");
                            TimeUnit.MILLISECONDS.sleep(1500);
                            System.out.println("* name : " + player.name);
                            System.out.println("* Level: " + player.level);
                            System.out.println("* Max HP: " + player.hpCap);
                            break;
                        }
                    }

                    break;
                // case 2 : blacksmith
                case 2:
                    System.out.println("You arrive at the Forgery and meet 'Whoami' the BlackSmith , who greets you kindly :");
                    TimeUnit.MILLISECONDS.sleep(1700);
                    System.out.println("Whoami : Here you can refine your items and attacks. I need materials and your money!");
                    TimeUnit.MILLISECONDS.sleep(1700);
                    // upgrades available to craft
                    System.out.println("[1]. Upgrade Bone Sword -> Sword Of Fiery Pits;");
                    System.out.println("[2]. Normal Middle Finger -> Reinforced Middle Finger;");
                    System.out.println("[Invalid Input]. Leave Blacksmith;");
                    switch (takeInput()) {
                        // case 1 : sword of fiery pits upgrade
                        case 1:
                            System.out.println("\n-Sword Of Fiery Pits-");
                            System.out.println("-".repeat(45));
                            System.out.println("<A Sword forged from Hell's most scorching fires and most Frightful Screams.>");
                            System.out.println("<'Slash' Attack Damage +5000,become Unkillable, The Reaper, The Ultimate Terror of HELL.>");
                            System.out.println("-".repeat(45));
                            // upgrade recipe (materials obtainable from defeating monsters)
                            System.out.println("* (x1) Rune of Demons;");
                            System.out.println("* 100 Coins;\n");
                            TimeUnit.MILLISECONDS.sleep(1500);
                            System.out.println("Whoami : Wanna craft this bad boy?");
                            TimeUnit.MILLISECONDS.sleep(1500);
                            System.out.println("[1].Yes;");
                            System.out.println("[2].No;");
                            System.out.println("[Invalid Input]. Leave Blacksmith;");
                            // switch case yes/no
                            switch (takeInput()) {
                                case 1:
                                    // case 1 : yes case
                                    // if player has enough materials/coins
                                    if (runeOfDemonsAmount > 0 && coinsAmount >= 100 && !swordOfFieryPits) {
                                        // player crafts sword and condition becomes true <=> player obtained upgrade
                                        swordOfFieryPits = true;
                                        System.out.println("Crafted SWORD OF FIERY PITS. (+5000 Damage on 'Slash' Attack)");
                                        runeOfDemonsAmount--;
                                        coinsAmount -= 100;
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                        // if player does not have enough materials/coins
                                    } else if (runeOfDemonsAmount <= 0 || coinsAmount <= 100) {
                                        System.out.println("Whoami : Not enough Coins/Materials buddy.");
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    }
                                    // condition to negate player from crafting items again and possibly wasting materials
                                    if (swordOfFieryPits) {
                                        System.out.println("Sword Of Fiery Pits already crafted.");
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    }
                                    break;

                                case 2:
                                    // case 2 : no case
                                    System.out.println("You chose not to craft the Sword.");
                                    TimeUnit.MILLISECONDS.sleep(1000);
                                    break;

                                default:
                            }
                            break;
                        case 2:
                            // case 2 : reinforced middle finger upgrade
                            System.out.println("\n-Reinforced Middle Finger-");
                            System.out.println("-".repeat(45));
                            System.out.println("<Boop your enemies harder than ever before.>");
                            System.out.println("<+5 Damage on 'Boop' Attack>");
                            System.out.println("-".repeat(45));
                            System.out.println("* (x5) Metal Scrap Pieces;");
                            System.out.println("* 35 Coins;\n");
                            TimeUnit.MILLISECONDS.sleep(1500);
                            System.out.println("Whoami : Ready for an Upgrade?");
                            System.out.println("[1].Yes;");
                            System.out.println("[2].No;");
                            System.out.println("[Invalid Input]. Leave Blacksmith;");
                            switch(takeInput()){
                                case 1 :
                                    // case 1 : yes case
                                    // check for player materials and already having reinforced middle finger crafted
                                    if(scrapMetalAmount >= 5 && coinsAmount >= 35 && !reinforcedMiddleFinger) {
                                        reinforcedMiddleFinger = true;
                                        System.out.println("Crafted Reinforced Middle Finger. (+5 Damage on 'Boop' Attack)");
                                        scrapMetalAmount -= 5;
                                        coinsAmount -= 35;
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                        // else if player doesn't have enough materials
                                    } else if(scrapMetalAmount < 5 || coinsAmount < 35){
                                        System.out.println("Whoami : Not enough Coins/Materials buddy.");
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    }
                                    // condition to negate player from crafting items again and possibly wasting materials
                                    if (reinforcedMiddleFinger){
                                        System.out.println("Finger already reinforced.");
                                        TimeUnit.MILLISECONDS.sleep(1000);
                                    }
                                    break;

                                case 2:
                                    // case 2 : no case
                                    System.out.println("You chose not to reinforce your middle finger.");
                                    TimeUnit.MILLISECONDS.sleep(1000);
                                    break;

                                default:
                            }
                            break;

                        default:
                    }
                    break;

                case 3:
                    // case 3 : vendor case
                    System.out.println("You arrived at the Vendor. Encountered 'Sauce The Vendor'. ");
                    System.out.println("Sauce : Pick a item to buy or get out of my store already.");
                    TimeUnit.MILLISECONDS.sleep(1500);
                    System.out.println("-".repeat(45));
                    System.out.println("Sauce's Shop || You have " + coinsAmount + " coins.");
                    System.out.println("-".repeat(45));
                    System.out.println("[1].MedKit (Heals 10 HP); || 10 COINS");
                    System.out.println("[2].Oreo Cookie (Take 4 less Damage on next Monster Attack); || 15 COINS");
                    System.out.println("[3].Manual of Bodily Health (Increases Player Overall HP by +5) || 50 COINS");
                    System.out.println("[Invalid Input].Leave Store");
                    // user item purchasing
                    switch (takeInput()) {
                        case 1:
                            // case 1 : medkit buying
                            // check for player coins amount >=10 (medkit price = 10)
                            if (coinsAmount >= 10) {
                                medKitAmount++;
                                coinsAmount -= 10;
                                System.out.println("You bought a MedKit for 10 coins.");
                                System.out.println("You now have " + coinsAmount + " coins left and " + medKitAmount + " MedKits.");
                            } else {
                                // if player coins amount <10
                                System.out.println("Sauce : Trying to steal moron? GET THE FUCK OUT!!");
                                TimeUnit.MILLISECONDS.sleep(2000);
                                System.out.println("You got kicked out for trying to steal.\n");
                                // "kick player out of store"
                                break;
                            }
                            break;

                        case 2:
                            // case 2 : oreo cookie buying
                            // check for player coins amount >=15 (oreo cookie price = 15)
                            if (coinsAmount >= 15) {
                                oreoCookieAmount++;
                                coinsAmount -= 15;
                            } else {
                                // if player coins amount <15
                                System.out.println("Sauce : That hungry for a cookie? Get out!");
                                TimeUnit.MILLISECONDS.sleep(2000);
                                System.out.println("You got kicked out for trying to steal.\n");
                                // "kick player out of store"
                                break;
                            }
                            break;

                        case 3:
                            // case 3 : manual of bodily health buying
                            // check for player coins amount >=50 (manual price = 50)
                            if (coinsAmount >= 50) {
                                // increase player hp capacity by 5
                                player.hpCap += 5;
                                System.out.println("You now have " + player.hpCap + " HP Limit. (+5 from Manual Of Bodily Health)\n");
                                coinsAmount -= 50;
                                TimeUnit.MILLISECONDS.sleep(1500);
                            } else {
                                // if player coins amount <50
                                System.out.println("Sauce : The Manual's a rare relic. Can't let you have that for free.");
                                TimeUnit.MILLISECONDS.sleep(2000);
                                System.out.println("You got kicked out for trying to steal.\n");
                                // "kick player out of store"
                                break;
                            }
                            break;

                        default:
                            System.out.println("You left the store. ");
                            break;
                    }
                    break;

                case 4:
                    // case 4 : player stats displaying
                    System.out.println("-STATS-");
                    System.out.printf("* Name: %s%n", player.name);
                    System.out.printf("* Level: %d, %d/%d EXP%n", player.level, playerEXP, levelEXP);
                    System.out.printf("* Max HP : %d%n", player.hpCap);
                    System.out.printf("* Current HP : %d%n", player.HP);
                    System.out.println("-INVENTORY-");
                    System.out.printf("* %d Coins%n", coinsAmount);
                    System.out.printf("* %d MedKits%n", medKitAmount);
                    System.out.printf("* %d Oreo Cookies\n%n", oreoCookieAmount);
                    TimeUnit.MILLISECONDS.sleep(2000);
                    break;

                default:
                    System.out.print("Please input valid number, ");
                    break;
            }
        }
        scanner.close();
    }
}