package ocb

class Contact {

    Integer id
    String name
    String image
    Member member

    Date dateCreated
    Date lastUpdated

    Set<ContactDetail> contactDetails
    Set<ContactGroup> contactGroups

    static hasMany = [contactDetails:ContactDetail, contactGroups:ContactGroup]

    static constraints = {
        image(nullable: true)
    }

    static mapping = {
        version(false)
        contactDetails(cascade: 'all-delete-orphan')
    }
}
