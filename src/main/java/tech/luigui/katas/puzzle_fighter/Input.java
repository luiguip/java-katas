package tech.luigui.katas.puzzle_fighter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tech.luigui.katas.puzzle_fighter.model.MovementEnum;
import tech.luigui.katas.puzzle_fighter.model.PieceEnum;

public final class Input {

	private final List<PieceEnum> pieces;
	private final List<MovementEnum> movements;
	
	Input(String rawPieces, String rawMovements) {
		pieces = generatePiecesFromString(rawPieces);
		movements = generateMovementsFromString(rawMovements);
	}

	private List<PieceEnum> generatePiecesFromString(String rawPieces) {
		return Arrays.stream(rawPieces.split(""))
				.map(PieceEnum::getByRawPiece)
				.collect(Collectors.toList());
	}

	private List<MovementEnum> generateMovementsFromString(String rawMovements) {
		return Arrays.stream(rawMovements.split(""))
				.map(MovementEnum::getByRawMovement)
				.collect(Collectors.toList());
	}

	public List<PieceEnum> getPieces() {
		return pieces;
	}

	public List<MovementEnum> getMovements() {
		return movements;
	}
	
	@Override
	public String toString() {
		String piecesString = pieces.toString();
		String movementsString = movements.toString();
		return "pieces: " + piecesString + "\nmovements: " + movementsString;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Input) {
			boolean arePiecesEquals = this.pieces.equals(((Input) other).getPieces());
			boolean areMovementsEquals = this.movements.equals(((Input) other).getMovements());
			return  arePiecesEquals && areMovementsEquals; 
		}
		return super.equals(other);
	}
}
