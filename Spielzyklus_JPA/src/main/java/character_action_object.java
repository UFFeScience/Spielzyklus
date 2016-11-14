



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
@javax.persistence.IdClass(character_action_objectId.class) 
public class character_action_object
{
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
	 
	@javax.persistence.OneToOne 
	protected object object;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected character_action character_action;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long objectId;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Enumerated(javax.persistence.EnumType.STRING) 
	@javax.persistence.Column(nullable = false) 
	protected  character_actionId;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public character_action_object(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetObject(object myObject) {
		if (this.object != myObject) {
			if (myObject != null){
				if (this.object != myObject) {
					object oldobject = this.object;
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
	public void basicSetCharacter_action(character_action myCharacter_action) {
		if (this.character_action != myCharacter_action) {
			if (myCharacter_action != null){
				if (this.character_action != myCharacter_action) {
					character_action oldcharacter_action = this.character_action;
					this.character_action = myCharacter_action;
					if (oldcharacter_action != null)
						oldcharacter_action.unsetObject();
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
	public String getLocation() {
		return this.location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public object getObject() {
		return this.object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public character_action getCharacter_action() {
		return this.character_action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getObjectId() {
		return this.objectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void () {
		return this.character_actionId;
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
	public void setObject(object myObject) {
		this.basicSetObject(myObject);
		myObject.basicSetCharacter_action(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setCharacter_action(character_action myCharacter_action) {
		this.basicSetCharacter_action(myCharacter_action);
		myCharacter_action.basicSetObject(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setObjectId(long myObjectId) {
		this.objectId = myObjectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setCharacter_actionId( myCharacter_actionId) {
		this.character_actionId = myCharacter_actionId;
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
	public void unsetObject() {
		if (this.object == null)
			return;
		object oldobject = this.object;
		this.object = null;
		oldobject.unsetCharacter_action();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetCharacter_action() {
		if (this.character_action == null)
			return;
		character_action oldcharacter_action = this.character_action;
		this.character_action = null;
		oldcharacter_action.unsetObject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetObjectId() {
		this.objectId = 0L;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetCharacter_actionId() {
		this.character_actionId = ;
	}

}

