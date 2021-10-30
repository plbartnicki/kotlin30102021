package delegations

//zasadniczy przyklad
class SaferAccountWithPropertyDelegate(val id: Int) {
    var updateCount = 0
    var toPay: Double by PositiveValueDelegate()
    var debt: Double by PositiveValueDelegate()
}