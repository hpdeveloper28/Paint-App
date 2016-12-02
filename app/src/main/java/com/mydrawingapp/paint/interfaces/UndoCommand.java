package com.mydrawingapp.paint.interfaces;

public interface UndoCommand {
    void undo();
    void redo();
    boolean canUndo();
    boolean canRedo();
}
