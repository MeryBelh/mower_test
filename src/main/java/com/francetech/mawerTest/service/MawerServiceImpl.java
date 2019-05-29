package com.francetech.mawerTest.service;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.francetech.mawerTest.helper.FileHelper;
import com.francetech.mawerTest.model.Lawn;
import com.francetech.mawerTest.model.Mower;
import com.francetech.mawerTest.model.Position;
import com.francetech.mawerTest.model.enumeration.Instruction;
import com.francetech.mawerTest.model.enumeration.Orientation;
import com.francetech.mawerTest.util.FileValidator;

@Component
public class MawerServiceImpl implements MawerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MawerServiceImpl.class);

    
	private static final String DEFAULT_FILE_NAME = "mowerSample.txt";

	public List<Mower> getMowerPositionList() {

		Lawn lawn = new Lawn();

		try {
			// read file line
			final List<String> lines = FileHelper.readFile(DEFAULT_FILE_NAME);

			// validate file
			FileValidator.validateLawn(lines);

			// configure Lawn
			lawn = configureLawn(lines.get(0));

			// get mowers
			List<Mower> mowers = new ArrayList<>();
			for (int i = 1; i < lines.size(); i += 2) {

				String[] position = lines.get(i).split(" ");
				if (position.length != 3) {
					throw new IllegalArgumentException(
							"A lawn mower position must comprise two 3 parts: coordinates (x, y) and the orientation");
				}
				// position of the mower
				Mower mower = new Mower(parseInt(position[0]), parseInt(position[1]),
						Orientation.valueOf(position[2].toUpperCase()));

				// execute instruction
				List<Instruction> instructions = new ArrayList<>();
				for (char c : lines.get(i + 1).toCharArray()) {
					instructions.add(Instruction.valueOf(Character.toString(c)));
				}
				mower.setInstructions(instructions);
				this.executeInstruction(mower, lawn);

				mowers.add(mower);
			}
			lawn.setMowerList(mowers);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return lawn.getMowerList();

	}
	

	private Lawn configureLawn ( String line){
		String[] dimensions = line.split(" ");
		int width = parseInt(dimensions[0]);
		int height = parseInt(dimensions[1]);
		return new Lawn(width, height);
	}
	
	private void executeInstruction(Mower mower, Lawn lawn) {

		for(Instruction instruction : mower.getInstructions()) {
			int initialX = mower.getPosition().getX();
			int initialY = mower.getPosition().getY();
			mower.executeInstruction(instruction);
			if(mower.getPosition().getX() > lawn.getHeight() || mower.getPosition().getY() > lawn.getWidth()) {
				mower.setPosition(new Position(initialX, initialY));
			}
		}

	}
}
