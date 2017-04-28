package npcgenerator;

import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JTabbedPane;

public class NPCgenerator extends JFrame {

    private JPanel mainPanel, genderPanel, racePanel, npcPanel, npcLabelPanel,
            npcTextFieldPanel, dicePanel, diceChoicePanel, diceThrowPanel;
    private JRadioButton male, female, na, human, cambion, changeling, clockwork,
            dwarf, elf, faun, goblin, halfling, hobgoblin, jotun, orc, pixie, revenant,
            salamander, d3, d4, d6, d8, d10, d12, d20, d100;
    private ButtonGroup genderGroup, raceGroup, diceGroup;
    private Border kehys;
    private TitledBorder genderBorder, raceBorder, npcBorder, diceChoiceBorder,
            diceThrowBorder;
    private JLabel nameLabel, genderLabel, raceLabel, darkmarkLabel, physicalLabel,
            personalityLabel, motivationLabel, throwResultLabel;
    private JTextField physicalTrait, personalityTrait, motivation, darkmark,
            throwResultTextField;
    private JButton createNPC, printNPC, throwDice;
    private JTabbedPane tabs;

    public NPCgenerator() {
        setTitle("NPCs and more, bit*es!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(350, 640);
        tabs = new JTabbedPane();

        //All containers and items for the npc / mainPanel
        mainPanel = new JPanel();
        genderPanel = new JPanel();
        racePanel = new JPanel(new GridLayout(0, 3));
        npcPanel = new JPanel();
        npcLabelPanel = new JPanel(new GridLayout(0, 1));
        npcTextFieldPanel = new JPanel(new GridLayout(0, 1));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        na = new JRadioButton("N/A");

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(na);

        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(na);
        kehys = BorderFactory.createEtchedBorder();
        genderBorder = BorderFactory.createTitledBorder(kehys, "Gender");
        genderPanel.setBorder(genderBorder);

        human = new JRadioButton("Human");
        cambion = new JRadioButton("Cambion");
        changeling = new JRadioButton("Changeling");
        clockwork = new JRadioButton("Clockwork");
        dwarf = new JRadioButton("Dwarf");
        faun = new JRadioButton("Faun");
        elf = new JRadioButton("Elf");
        goblin = new JRadioButton("Goblin");
        halfling = new JRadioButton("Halfling");
        hobgoblin = new JRadioButton("Hobgoblin");
        jotun = new JRadioButton("Jotun");
        orc = new JRadioButton("Orc");
        pixie = new JRadioButton("Pixie");
        revenant = new JRadioButton("Revenant");
        salamander = new JRadioButton("Salamander");

        raceGroup = new ButtonGroup();
        raceGroup.add(human);
        raceGroup.add(cambion);
        raceGroup.add(changeling);
        raceGroup.add(clockwork);
        raceGroup.add(dwarf);
        raceGroup.add(elf);
        raceGroup.add(faun);
        raceGroup.add(goblin);
        raceGroup.add(halfling);
        raceGroup.add(hobgoblin);
        raceGroup.add(jotun);
        raceGroup.add(orc);
        raceGroup.add(pixie);
        raceGroup.add(revenant);
        raceGroup.add(salamander);

        racePanel.add(human);
        racePanel.add(cambion);
        racePanel.add(changeling);
        racePanel.add(clockwork);
        racePanel.add(dwarf);
        racePanel.add(elf);
        racePanel.add(faun);
        racePanel.add(goblin);
        racePanel.add(halfling);
        racePanel.add(hobgoblin);
        racePanel.add(jotun);
        racePanel.add(orc);
        racePanel.add(pixie);
        racePanel.add(revenant);
        racePanel.add(salamander);
        raceBorder = BorderFactory.createTitledBorder(kehys, "Race");
        racePanel.setBorder(raceBorder);

        //npc random name & trait generator panel (+ show gender and race)
        createNPC = new JButton(new AbstractAction("Create") {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcCobbler();
            }
        });
        printNPC = new JButton(new AbstractAction("Print NPC") {
            @Override
            public void actionPerformed(ActionEvent e) {
                npcPrinter();
            }
        });
        nameLabel = new JLabel("Name: ");
        genderLabel = new JLabel("Gender: ");
        raceLabel = new JLabel("Race: ");
        physicalLabel = new JLabel("Physical trait:");
        personalityLabel = new JLabel("Personality trait:");
        motivationLabel = new JLabel("Motivation:");
        darkmarkLabel = new JLabel("Mark of Darkness");

        physicalTrait = new JTextField(25);
        personalityTrait = new JTextField(25);
        motivation = new JTextField(25);
        darkmark = new JTextField(25);

        npcTextFieldPanel.add(createNPC);
        //npcTextFieldPanel.add(printNPC);
        npcTextFieldPanel.add(nameLabel);
        npcTextFieldPanel.add(genderLabel);
        npcTextFieldPanel.add(raceLabel);
        npcTextFieldPanel.add(physicalLabel);
        npcTextFieldPanel.add(physicalTrait);
        npcTextFieldPanel.add(personalityLabel);
        npcTextFieldPanel.add(personalityTrait);
        npcTextFieldPanel.add(motivationLabel);
        npcTextFieldPanel.add(motivation);
        npcTextFieldPanel.add(darkmarkLabel);
        npcTextFieldPanel.add(darkmark);
        npcPanel.add(npcTextFieldPanel);

        npcBorder = BorderFactory.createTitledBorder(kehys, "Create your NPC!");
        npcPanel.setBorder(npcBorder);

        mainPanel.add(genderPanel);
        mainPanel.add(racePanel);
        mainPanel.add(npcPanel);

        //All containers and items for the Dice thrower / dicePanel
        dicePanel = new JPanel(new GridLayout(4, 2));
        diceChoicePanel = new JPanel(new GridLayout(4, 4));
        diceThrowPanel = new JPanel(new GridLayout(0, 1));
        diceGroup = new ButtonGroup();

        d3 = new JRadioButton("D3");
        d4 = new JRadioButton("D4");
        d6 = new JRadioButton("D6");
        d8 = new JRadioButton("D8");
        d10 = new JRadioButton("D10");
        d12 = new JRadioButton("D12");
        d20 = new JRadioButton("D20");
        d100 = new JRadioButton("D100");
        throwDice = new JButton(new AbstractAction("Throw!") {
            @Override
            public void actionPerformed(ActionEvent e) {
                diceThrower();
            }
        });

        throwResultLabel = new JLabel("Result: ");

        diceGroup.add(d3);
        diceGroup.add(d4);
        diceGroup.add(d6);
        diceGroup.add(d8);
        diceGroup.add(d10);
        diceGroup.add(d12);
        diceGroup.add(d20);
        diceGroup.add(d100);

        diceChoicePanel.add(d3);
        diceChoicePanel.add(d4);
        diceChoicePanel.add(d6);
        diceChoicePanel.add(d8);
        diceChoicePanel.add(d10);
        diceChoicePanel.add(d12);
        diceChoicePanel.add(d20);
        diceChoicePanel.add(d100);

        diceChoiceBorder = BorderFactory.createTitledBorder(kehys, "Choose your die!");
        diceChoicePanel.setBorder(diceChoiceBorder);

        diceThrowBorder = BorderFactory.createTitledBorder(kehys, "Throw");
        diceThrowPanel.setBorder(diceThrowBorder);

        diceThrowPanel.add(throwDice);
        diceThrowPanel.add(throwResultLabel);

        dicePanel.add(diceChoicePanel);
        dicePanel.add(diceThrowPanel);

        tabs.addTab("NPC", mainPanel);
        tabs.addTab("Dice Thrower", dicePanel);

        setContentPane(tabs);
        //pack();
        setVisible(true);
    }

    public void npcCobbler() {

        nameCobbler();
        genderCobbler();
        raceCobbler();
        physicalCobbler();
        personalityCobbler();
        motivation("./traitlists/motivation.txt");
        darkmark("./traitlists/darkmarklist.txt");
    }

    public void personalityCobbler() {
        if (pixie.isSelected()) {
            personalityTraits("./traitlists/pixiepersonality.txt");
        } else {
            personalityTraits("./traitlists/personalitytraits.txt");
        }
    }

    public void raceCobbler() {

        String raceString = "";
        if (human.isSelected()) {
            raceString = human.getText();
        } else if (cambion.isSelected()) {
            raceString = cambion.getText();
        } else if (changeling.isSelected()) {
            raceString = changeling.getText();
        } else if (clockwork.isSelected()) {
            raceString = clockwork.getText();
        } else if (dwarf.isSelected()) {
            raceString = dwarf.getText();
        } else if (elf.isSelected()) {
            raceString = elf.getText();
        } else if (faun.isSelected()) {
            raceString = faun.getText();
        } else if (goblin.isSelected()) {
            raceString = goblin.getText();
        } else if (halfling.isSelected()) {
            raceString = halfling.getText();
        } else if (hobgoblin.isSelected()) {
            raceString = hobgoblin.getText();
        } else if (jotun.isSelected()) {
            raceString = jotun.getText();
        } else if (orc.isSelected()) {
            raceString = orc.getText();
        } else if (pixie.isSelected()) {
            raceString = pixie.getText();
        } else if (revenant.isSelected()) {
            raceString = revenant.getText();
        } else if (salamander.isSelected()) {
            raceString = salamander.getText();
        }
        raceLabel.setText("Race: " + raceString);
    }

    public void genderCobbler() {

        String genderString = "Gender: ";
        if (male.isSelected()) {
            genderString = "Gender: Male";
        } else if (female.isSelected()) {
            genderString = "Gender: Female";
        } else if (na.isSelected()) {
            genderString = "Gender: N/A";
        }
        genderLabel.setText(genderString);
    }

    public void nameCobbler() {

        if (human.isSelected()) {
            if (male.isSelected()) {
                generateName("./namelists/humanmalelist.txt");
            } else if (female.isSelected()) {
                generateName("./namelists/humanfemalelist.txt");
            }
        } else if (cambion.isSelected()) {
            if (male.isSelected()) {
                generateName("./namelists/humanmalelist.txt");
            } else if (female.isSelected()) {
                generateName("./namelists/humanfemalelist.txt");
            }
        } else if (changeling.isSelected()) {
            generateName("./namelists/changelinglist.txt");

        } else if (clockwork.isSelected()) {
            generateName("./namelists/clockworklist.txt");

        } else if (dwarf.isSelected()) {
            if (male.isSelected()) {
                generateName("./namelists/dwarfmalelist.txt");
            } else if (female.isSelected()) {
                generateName("./namelists/dwarffemalelist.txt");
            }

        } else if (elf.isSelected()) {
            generateName("./namelists/elflist.txt");

        } else if (faun.isSelected()) {

        } else if (goblin.isSelected()) {
            generateName("./namelists/goblinlist.txt");

        } else if (halfling.isSelected()) {
            if (male.isSelected()) {
                generateName("./namelists/halflingmalelist.txt");
            } else if (female.isSelected()) {
                generateName("./namelists/halflingfemalelist.txt");
            }

        } else if (hobgoblin.isSelected()) {
            generateName("./namelists/hobgoblinlist.txt");

        } else if (jotun.isSelected()) {
            if (male.isSelected()) {
                generateName("./namelists/jotunmalelist.txt");
            } else if (female.isSelected()) {
                generateName("./namelists/jotunfemalelist.txt");
            }

        } else if (orc.isSelected()) {
            generateName("./namelists/orclist.txt");

        } else if (pixie.isSelected()) {
            generateName("./namelists/pixielist.txt");

        } else if (revenant.isSelected()) {
            if (male.isSelected()) {
                generateName("./namelists/humanmalelist.txt");
            } else if (female.isSelected()) {
                generateName("./namelists/humanfemalelist.txt");
            }

        } else if (salamander.isSelected()) {
            //generateName("humanlist.txt");

        }
    }

    public void generateName(String list) {

        File generateList = new File(list);
        ArrayList<String> nameList = new ArrayList<String>();
        String name = "";
        try {
            Scanner nameListReader = new Scanner(generateList);
            while (nameListReader.hasNextLine()) {
                nameList.add(nameListReader.nextLine());
            }
        } catch (FileNotFoundException a) {

        }
        name = nameList.get(randomizer(nameList.size()));
        nameLabel.setText("Name: " + name);
    }

    public void physicalCobbler() {
        if (elf.isSelected()) {
            physicalTraits("./traitlists/elfphysical.txt");
        } else if (pixie.isSelected()) {
            physicalTraits("./traitlists/pixiephysical.txt");
        } else if (clockwork.isSelected()) {
            physicalTraits("./traitlists/clockworkphysical.txt");
        } else if (goblin.isSelected()) {
            physicalTraits("./traitlists/goblinphysical.txt");
        } else if (hobgoblin.isSelected()) {
            physicalTrait.setText("Jowly, spindly limbs and a big, "
                    + "distended belly");
        } else {
            physicalTraits("./traitlists/physicaltraits.txt");
        }
    }

    public void physicalTraits(String list) {

        File generateList = new File(list);
        ArrayList<String> traitList = new ArrayList<String>();
        String trait = "";
        try {
            Scanner traitListReader = new Scanner(generateList);
            while (traitListReader.hasNextLine()) {
                traitList.add(traitListReader.nextLine());
            }
        } catch (FileNotFoundException a) {

        }
        physicalTrait.setText(traitList.get(randomizer(traitList.size())));
    }

    public void personalityTraits(String list) {
        File generateList = new File(list);
        ArrayList<String> traitList = new ArrayList<String>();
        try {
            Scanner traitListReader = new Scanner(generateList);
            while (traitListReader.hasNextLine()) {
                traitList.add(traitListReader.nextLine());
            }
        } catch (FileNotFoundException a) {

        }
        personalityTrait.setText(traitList.get(randomizer(traitList.size())));
    }

    public void motivation(String list) {
        File generateList = new File(list);
        ArrayList<String> traitList = new ArrayList<String>();
        String trait = "";
        try {
            Scanner traitListReader = new Scanner(generateList);
            while (traitListReader.hasNextLine()) {
                traitList.add(traitListReader.nextLine());
            }
        } catch (FileNotFoundException a) {

        }
        motivation.setText(traitList.get(randomizer(traitList.size())));

    }

    public void darkmark(String list) {
        File generateList = new File(list);
        ArrayList<String> traitList = new ArrayList<String>();
        String trait = "";
        try {
            Scanner traitListReader = new Scanner(generateList);
            while (traitListReader.hasNextLine()) {
                traitList.add(traitListReader.nextLine());
            }
        } catch (FileNotFoundException a) {

        }
        darkmark.setText(traitList.get(randomizer(traitList.size())));

    }

    public void npcPrinter() {

    }

    public int randomizer(int number) {
        Random randy = new Random();
        int result = randy.nextInt(number);
        return result;
    }

    public void diceThrower() {
        if (d3.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(3) + 1));
        } else if (d4.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(4) + 1));
        } else if (d6.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(6) + 1));
        } else if (d8.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(8) + 1));
        } else if (d10.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(10) + 1));
        } else if (d12.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(12) + 1));
        } else if (d20.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(20) + 1));
        } else if (d100.isSelected()) {
            throwResultLabel.setText("Result: " + (randomizer(100) + 1));
        }
    }

    public static void main(String[] args) {
        new NPCgenerator();
    }

}
