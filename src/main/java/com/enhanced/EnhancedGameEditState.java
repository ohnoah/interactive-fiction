package com.enhanced;

import java.io.Serializable;

public enum EnhancedGameEditState implements Serializable {
   OPEN,
   SAVE_FILENAME,
   ROOM_NAME,
   ROOM_ITEMS,
   ACTION_ROOM,
   ACTION_TRIGGER,
   ACTION_TRIGGER_CLARIFY,
   ACTION_ARGS,
   ACTION_PRE,
   ACTION_POST,
   ACTION_MSG,
   EDIT_KNOWLEDGE,
   FILLERS,
   PARENTS_CHILD,
   PARENTS_PARENT,
   PARENTS_NEW_NAME,
   PARENTS_NEW_SLOTS,
   LOAD
}
