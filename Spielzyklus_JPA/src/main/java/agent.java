



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class agent
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "actedOnBehalfOf") 
	protected agent agent;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected agent actedOnBehalfOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "agent") 
	protected entity wasAttributedTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "agent") 
	protected activity wasAssociatedWith;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public agent(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetAgent(agent myAgent) {
		if (this.agent != myAgent) {
			if (myAgent != null){
				if (this.agent != myAgent) {
					agent oldagent = this.agent;
					this.agent = myAgent;
					if (oldagent != null)
						oldagent.unsetActedOnBehalfOf();
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
	public void basicSetActedOnBehalfOf(agent myActedOnBehalfOf) {
		if (this.actedOnBehalfOf != myActedOnBehalfOf) {
			if (myActedOnBehalfOf != null){
				if (this.actedOnBehalfOf != myActedOnBehalfOf) {
					agent oldactedOnBehalfOf = this.actedOnBehalfOf;
					this.actedOnBehalfOf = myActedOnBehalfOf;
					if (oldactedOnBehalfOf != null)
						oldactedOnBehalfOf.unsetAgent();
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
	public void basicSetWasAttributedTo(entity myWasAttributedTo) {
		if (this.wasAttributedTo != myWasAttributedTo) {
			if (myWasAttributedTo != null){
				if (this.wasAttributedTo != myWasAttributedTo) {
					entity oldwasAttributedTo = this.wasAttributedTo;
					this.wasAttributedTo = myWasAttributedTo;
					if (oldwasAttributedTo != null)
						oldwasAttributedTo.unsetAgent();
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
	public void basicSetWasAssociatedWith(activity myWasAssociatedWith) {
		if (this.wasAssociatedWith != myWasAssociatedWith) {
			if (myWasAssociatedWith != null){
				if (this.wasAssociatedWith != myWasAssociatedWith) {
					activity oldwasAssociatedWith = this.wasAssociatedWith;
					this.wasAssociatedWith = myWasAssociatedWith;
					if (oldwasAssociatedWith != null)
						oldwasAssociatedWith.unsetAgent();
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
	public agent getAgent() {
		return this.agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public agent getActedOnBehalfOf() {
		return this.actedOnBehalfOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public entity getWasAttributedTo() {
		return this.wasAttributedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public activity getWasAssociatedWith() {
		return this.wasAssociatedWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setAgent(agent myAgent) {
		this.basicSetAgent(myAgent);
		myAgent.basicSetActedOnBehalfOf(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setActedOnBehalfOf(agent myActedOnBehalfOf) {
		this.basicSetActedOnBehalfOf(myActedOnBehalfOf);
		myActedOnBehalfOf.basicSetAgent(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setWasAttributedTo(entity myWasAttributedTo) {
		this.basicSetWasAttributedTo(myWasAttributedTo);
		myWasAttributedTo.basicSetAgent(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setWasAssociatedWith(activity myWasAssociatedWith) {
		this.basicSetWasAssociatedWith(myWasAssociatedWith);
		myWasAssociatedWith.basicSetAgent(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetAgent() {
		if (this.agent == null)
			return;
		agent oldagent = this.agent;
		this.agent = null;
		oldagent.unsetActedOnBehalfOf();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetActedOnBehalfOf() {
		if (this.actedOnBehalfOf == null)
			return;
		agent oldactedOnBehalfOf = this.actedOnBehalfOf;
		this.actedOnBehalfOf = null;
		oldactedOnBehalfOf.unsetAgent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetWasAttributedTo() {
		if (this.wasAttributedTo == null)
			return;
		entity oldwasAttributedTo = this.wasAttributedTo;
		this.wasAttributedTo = null;
		oldwasAttributedTo.unsetAgent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetWasAssociatedWith() {
		if (this.wasAssociatedWith == null)
			return;
		activity oldwasAssociatedWith = this.wasAssociatedWith;
		this.wasAssociatedWith = null;
		oldwasAssociatedWith.unsetAgent();
	}

}

