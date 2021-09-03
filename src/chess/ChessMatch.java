package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch () {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows();i++) {
			
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}			
		}
		return mat;
		
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece captoredPiece = makeMove(source, target);
		return (ChessPiece)captoredPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(source);
		board.PlacePiece(p, target);
		return capturedPiece;
				
		
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAsPiece(position)) {
			throw new ChessException("Não existe peça na posição de origem");
		}
		if (!board.thereIsAsPiece(position)) {
			throw new ChessException("Não há movimentações possiveis para a peça");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.PlacePiece(piece,  new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
	
		
		placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        //placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        //placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        //placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        //placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        //placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        //placeNewPiece('a', 2, new Pawn(board, Color.WHITE, this));
        //placeNewPiece('b', 2, new Pawn(board, Color.WHITE, this));
        //placeNewPiece('c', 2, new Pawn(board, Color.WHITE, this));
        //placeNewPiece('d', 2, new Pawn(board, Color.WHITE, this));
        //placeNewPiece('e', 2, new Pawn(board, Color.WHITE, this));
        //placeNewPiece('f', 2, new Pawn(board, Color.WHITE, this));
        //placeNewPiece('g', 2, new Pawn(board, Color.WHITE, this));
        //placeNewPiece('h', 2, new Pawn(board, Color.WHITE, this));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        //placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        //placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        //placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        //placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        //placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        //placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        //placeNewPiece('a', 7, new Pawn(board, Color.BLACK, this));
        //placeNewPiece('b', 7, new Pawn(board, Color.BLACK, this));
        //placeNewPiece('c', 7, new Pawn(board, Color.BLACK, this));
        //placeNewPiece('d', 7, new Pawn(board, Color.BLACK, this));
        //placeNewPiece('e', 7, new Pawn(board, Color.BLACK, this));
        //placeNewPiece('f', 7, new Pawn(board, Color.BLACK, this));
        //placeNewPiece('g', 7, new Pawn(board, Color.BLACK, this));
        //placeNewPiece('h', 7, new Pawn(board, Color.BLACK, this));

	}

}
