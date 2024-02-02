package br.unicap.nomedisciplina.atividade00.TestObjective;

import br.unicap.nomedisciplina.atividade00.calculations.MatchCreation;
import br.unicap.nomedisciplina.atividade00.calculations.ObjetiveValidation;
import br.unicap.nomedisciplina.atividade00.calculations.StartingAttributes;
import br.unicap.nomedisciplina.atividade00.match.Objective.Objective;
import br.unicap.nomedisciplina.atividade00.match.Objective.ObjectiveConquestTerritoryNotSpecific;
import br.unicap.nomedisciplina.atividade00.match.Objective.ObjectiveConquestTerritorySpecific;
import br.unicap.nomedisciplina.atividade00.match.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class TestConquestTerritoryNotSpecific {
    private LinkedList<Player> playes;
    private Player player;
    private Objective objective;
    private MatchCreation creation;
    private StartingAttributes attributes;
    private ObjetiveValidation actualValidation;

    @BeforeEach
    public void setUp() {
        this.creation = new MatchCreation();
        this.attributes = new StartingAttributes();
        this.actualValidation = new ObjetiveValidation();
        this.playes = new LinkedList<>();
        creation.creationPlayer(this.playes);
        this.objective = new ObjectiveConquestTerritoryNotSpecific(6, this.attributes.getDescription()[1], this.playes.getFirst().getId());
        this.playes.getFirst().setObjPlayer(this.objective);
        this.player = this.playes.getFirst();
        this.attributes.setEarlyArmys(this.player.getTotalArmys());
    }

    @Test
    public void testActualPlayerhasObjectiveConquestTerritoryNotSpecific() {
        boolean actual = actualValidation.validationSameObjective(this.player, this.objective);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualPlayerhasNotObjectiveEliminateTarget() {
        Objective newObjective = new ObjectiveConquestTerritorySpecific(0, this.attributes.getDescription()[1], this.player.getId());
        this.player.setObjPlayer(newObjective);
        boolean actual = actualValidation.validationSameObjective(this.player, this.objective);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualPlayerhasConquestRequiredQuantity() {
        this.playes.getFirst().setTotalArmys(24);
        boolean actual = actualValidation.validationConquestConquestRequiredQuantity(this.playes, (ObjectiveConquestTerritoryNotSpecific) objective);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualPlayerhasNotConquestRequiredQuantity() {
        boolean actual = actualValidation.validationConquestConquestRequiredQuantity(this.playes, (ObjectiveConquestTerritoryNotSpecific) objective);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
