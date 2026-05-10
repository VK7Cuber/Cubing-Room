package com.example.cubing_room;

import com.example.cubing_room.exceptions.IncorrectCubeStateException;
import com.example.cubing_room.exceptions.IncorrectStateColorException;

import org.worldcubeassociation.tnoodle.scrambles.Puzzle;
import org.worldcubeassociation.tnoodle.scrambles.PuzzleRegistry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs.min2phase.Search;

public class RubiksCube {
    private static RubiksCube instance;
    private String cubeState;
    private final Map<Character, Character> colorSymbols;
    private final Puzzle scrambler;
    private Search solver;


    private final List<Integer> maxDepthValuesArray;
    private final List<Integer> timeOutValuesArray;
    private final List<Integer> minProbesValuesArray;


    public RubiksCube(){
        scrambler = PuzzleRegistry.THREE.getScrambler();

        colorSymbols = new LinkedHashMap<>();
        colorSymbols.put('w', 'U');
        colorSymbols.put('r', 'R');
        colorSymbols.put('g', 'F');
        colorSymbols.put('y', 'D');
        colorSymbols.put('o', 'L');
        colorSymbols.put('b', 'B');
        cubeState = getSolvedCubeState();

        maxDepthValuesArray = new ArrayList<>();
        maxDepthValuesArray.add(30);
        maxDepthValuesArray.add(22);
        maxDepthValuesArray.add(20);

        timeOutValuesArray = new ArrayList<>();
        timeOutValuesArray.add(100_000);
        timeOutValuesArray.add(100_000_000);
        timeOutValuesArray.add(500_000_000);

        minProbesValuesArray = new ArrayList<>();
        minProbesValuesArray.add(0);
        minProbesValuesArray.add(1_000);
        minProbesValuesArray.add(5_000);
    }

    public static RubiksCube getInstance(){
        if (instance == null){
            instance = new RubiksCube();
        }
        return instance;
    }

    private String getSolvedCubeState(){
        StringBuilder state = new StringBuilder();
        for (Character color: colorSymbols.values()){
            for (int i = 0; i < 9; i++){
                state.append(color);
            }
        }
        return state.toString();
    }

    public void initSolver(){
        solver = new Search();
    }

    public void testSolver(){
        getSolvingAlgorithm(0);
    }

    public String getSolvingAlgorithm(int maxDepth, int timeOut, int minProbes, int outputFormattingFlag){
        return solver.solution(
                cubeState,
                maxDepthValuesArray.get(maxDepth),
                timeOutValuesArray.get(timeOut),
                minProbesValuesArray.get(minProbes),
                outputFormattingFlag

        );
    }


    public String getSolvingAlgorithm(int optimizationLevel, int outputFormattingFlag){
        return solver.solution(
                cubeState,
                maxDepthValuesArray.get(optimizationLevel),
                timeOutValuesArray.get(optimizationLevel),
                minProbesValuesArray.get(optimizationLevel),
                outputFormattingFlag

        );
    }

    public String getSolvingAlgorithm(int optimizationLevel){
        return solver.solution(
                cubeState,
                maxDepthValuesArray.get(optimizationLevel),
                timeOutValuesArray.get(optimizationLevel),
                minProbesValuesArray.get(optimizationLevel),
                0

        );
    }

    public String generateScramble(){
        return scrambler.generateScramble();
    }

    public void setCubeState(String state) throws IncorrectCubeStateException, IncorrectStateColorException {
        if (state.length() != 54){
            throw new IncorrectCubeStateException("Cube state length must be 54 characters!");
        }
        cubeState = "";
        for (int i = 0; i < state.length(); i++){
            try {
                cubeState += colorSymbols.get(state.charAt(i));
            } catch (Exception e) {
                throw new IncorrectStateColorException("Incorrect symbol" + state.charAt(i) + ". You can only use symbols w, y, g, o, b, r in cube state sting!");
            }
        }
    }

    public void setSolvedCubeState(){
        cubeState = getSolvedCubeState();
    }
}
