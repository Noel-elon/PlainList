package com.noelon.core_data.mapper

import com.noelon.core_common.UserModel
import com.noelon.core_database.entity.UserEntity
import com.noelon.core_network.models.Result


fun List<UserEntity>.toModelList(): List<UserModel> {
    return this.map {
        UserModel(
            firstName = it.firstName,
            lastName = it.lastName,
            address = it.address,
            image = it.image,
            phoneNumber = it.phoneNumber,
            email = it.email
        )
    }
}


fun Result.toUserEntity(): UserEntity {
    return UserEntity(
        firstName = this.name.first,
        lastName = this.name.last,
        address = "${this.location.street} ${this.location.city} ${this.location.state} ${this.location.country}",
        image = this.picture.thumbnail,
        phoneNumber = this.phone,
        email = this.email
    )
}
