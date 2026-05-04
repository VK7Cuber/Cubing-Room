package com.example.cubing_room;

import org.worldcubeassociation.tnoodle.scrambles.Puzzle;
import org.worldcubeassociation.tnoodle.scrambles.PuzzleRegistry;

public class RubiksCube {
    private String cubeState;
    private Puzzle scrambler;

    public RubiksCube(){
        cubeState = "";
        scrambler = PuzzleRegistry.THREE.getScrambler();
    }

    public String generateScramble(){
        return scrambler.generateScramble();
    }
}
