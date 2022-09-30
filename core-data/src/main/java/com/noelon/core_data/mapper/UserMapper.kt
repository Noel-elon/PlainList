package com.noelon.core_data.mapper

import com.noelon.core_common.UserModel
import com.noelon.core_database.entity.UserEntity
import com.noelon.core_network.models.Result

fun UserEntity.toUserModel(): UserModel {
    return UserModel(
        firstName, lastName, address, image, phoneNumber, email
    )
}

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

fun List<com.noelon.core_network.models.Result>.toUserEntityList(): List<UserEntity> {
    return this.map { res ->
        UserEntity(
            firstName = res.name.first,
            lastName = res.name.last,
            address = "${res.location.street} ${res.location.city} ${res.location.state} ${res.location.country}",
            image = res.picture.thumbnail,
            phoneNumber = res.phone,
            email = res.email
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

fun List<Result>.toUserModelList(): List<UserModel> {
    return this.map { res ->
        UserModel(
            firstName = res.name.first,
            lastName = res.name.last,
            address = "${res.location.street} ${res.location.city} ${res.location.state} ${res.location.country}",
            image = res.picture.thumbnail,
            phoneNumber = res.phone,
            email = res.email
        )
    }
}