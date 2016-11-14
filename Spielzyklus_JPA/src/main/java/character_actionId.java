	public class character_actionId implements java.io.Serializable {
			private  actionId;
			private long characterId;
	
			public int hasCode() {
				return (int)(actionId + characterId);
			}
	
			public boolean equals(Object object) {
	   			if (object instanceof character_actionId) {
	      			character_actionId otherId = (character_actionId) object;
	      			return (otherId.actionId == this.actionId) && (otherId.characterId == this.characterId);
	   			}
	    		return false;
	  		}
		}
