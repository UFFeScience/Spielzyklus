
import java.util.Date;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
@javax.persistence.IdClass(character_actionId.class) 
public class character_action
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Temporal(javax.persistence.TemporalType.DATE) 
	@javax.persistence.Column(nullable = false) 
	protected Date date;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String location;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected gameSession gameSession;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected action action;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected character character;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Enumerated(javax.persistence.EnumType.STRING) 
	@javax.persistence.Column(nullable = false) 
	protected  actionId;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long characterId;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.OneToOne 
	protected character_action_object object;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public character_action(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetGameSession(gameSession myGameSession) {
		if (this.gameSession != myGameSession) {
			if (myGameSession != null){
				if (this.gameSession != myGameSession) {
					gameSession oldgameSession = this.gameSession;
					this.gameSession = myGameSession;
					if (oldgameSession != null)
						oldgameSession.removeCharacter_action(this);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetAction(action myAction) {
		if (this.action != myAction) {
			if (myAction != null){
				if (this.action != myAction) {
					action oldaction = this.action;
					this.action = myAction;
					if (oldaction != null)
						oldaction.unsetCharacter();
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetCharacter(character myCharacter) {
		if (this.character != myCharacter) {
			if (myCharacter != null){
				if (this.character != myCharacter) {
					character oldcharacter = this.character;
					this.character = myCharacter;
					if (oldcharacter != null)
						oldcharacter.unsetAction();
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetObject(character_action_object myObject) {
		if (this.object != myObject) {
			if (myObject != null){
				if (this.object != myObject) {
					character_action_object oldobject = this.object;
					this.object = myObject;
					if (oldobject != null)
						oldobject.unsetCharacter_action();
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public String getLocation() {
		return this.location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public gameSession getGameSession() {
		return this.gameSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public action getAction() {
		return this.action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public character getCharacter() {
		return this.character;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void () {
		return this.actionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getCharacterId() {
		return this.characterId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public character_action_object getObject() {
		return this.object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setDate(Date myDate) {
		this.date = myDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setLocation(String myLocation) {
		this.location = myLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setGameSession(gameSession myGameSession) {
		this.basicSetGameSession(myGameSession);
		myGameSession.addCharacter_action(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setAction(action myAction) {
		this.basicSetAction(myAction);
		myAction.basicSetCharacter(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setCharacter(character myCharacter) {
		this.basicSetCharacter(myCharacter);
		myCharacter.basicSetAction(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setActionId( myActionId) {
		this.actionId = myActionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setCharacterId(long myCharacterId) {
		this.characterId = myCharacterId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setObject(character_action_object myObject) {
		this.basicSetObject(myObject);
		myObject.basicSetCharacter_action(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetDate() {
		this.date = new Date();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetLocation() {
		this.location = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetGameSession() {
		if (this.gameSession == null)
			return;
		gameSession oldgameSession = this.gameSession;
		this.gameSession = null;
		oldgameSession.removeCharacter_action(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetAction() {
		if (this.action == null)
			return;
		action oldaction = this.action;
		this.action = null;
		oldaction.unsetCharacter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetCharacter() {
		if (this.character == null)
			return;
		character oldcharacter = this.character;
		this.character = null;
		oldcharacter.unsetAction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetActionId() {
		this.actionId = ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetCharacterId() {
		this.characterId = 0L;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetObject() {
		if (this.object == null)
			return;
		character_action_object oldobject = this.object;
		this.object = null;
		oldobject.unsetCharacter_action();
	}

}

