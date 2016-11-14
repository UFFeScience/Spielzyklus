	public class character_action_objectId implements java.io.Serializable {
			private long objectId;
			private long character_actionId;
	
			public int hasCode() {
				return (int)(objectId + character_actionId);
			}
	
			public boolean equals(Object object) {
	   			if (object instanceof character_action_objectId) {
	      			character_action_objectId otherId = (character_action_objectId) object;
	      			return (otherId.objectId == this.objectId) && (otherId.character_actionId == this.character_actionId);
	   			}
	    		return false;
	  		}
		}
