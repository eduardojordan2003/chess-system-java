package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "K";
	}

	public boolean canMoves(Position position){
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
	
		Position p = new Position(0, 0);
		//Acima
		p.setValues(position.getRow() -1, position.getColumn());
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Abaixo
		p.setValues(position.getRow() +1, position.getColumn());
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Direita
		p.setValues(position.getRow(), position.getColumn() +1);
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Diagonal Superior Esquerda
		p.setValues(position.getRow() -1, position.getColumn() -1);
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Diagonal Superior Direita
		p.setValues(position.getRow() -1, position.getColumn() +1);
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Diagonal Inferior Esquerda
		p.setValues(position.getRow() +1, position.getColumn() -1);
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//Diagonal Inferior Esquerda
		p.setValues(position.getRow() +1, position.getColumn() +1);
		if(getBoard().positionExists(p) && canMoves(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
}
