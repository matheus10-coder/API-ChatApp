package com.kotlin.matech.chatapp.controllers

import com.kotlin.matech.chatapp.dto.MessageDTO
import com.pusher.rest.Pusher
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("matech/api")
class ChatController {

    @PostMapping("/messages")
    fun messages(@RequestBody body: MessageDTO) : ResponseEntity<Any>{
        /** Connect with pusher to send events
         * pusher.com is my cloud repo where my own app is created utilizing their react
         * framework, it generates an api key with encrypted passw. also i had to add
         * maven repo
         */
        val pusher = Pusher("1888064", "aaf95a6a36f85a824662", "c38918e428a256a7a442")
        pusher.setCluster("us2")
        pusher.setEncrypted(true)

        /**Send the user message to pusher*/
        pusher.trigger("chat", "message", body)

        return ResponseEntity.ok(emptyArray<String>())
    }

}