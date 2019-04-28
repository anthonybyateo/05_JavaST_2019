USE `think`;

-- select from UserDaoImp
SELECT `login`, `email`, `password`, `role` FROM `users` WHERE `id` = 2;
SELECT `id`, `login`, `email`, `password`, `role` FROM `users` ORDER BY `login`;

-- select from SubscriptionDaoImp
SELECT `subscriber_id` FROM `subscription` WHERE `user_id` = 2;

-- select from NoteDaoImp
SELECT `id`, `user_id`, `note`, `date_notes` FROM `notes` ORDER BY `date_notes` DESC;
SELECT notes.id, notes.user_id, notes.note, notes.date_notes
        FROM notes JOIN subscription
        ON subscription.subscriber_id = 1 AND subscription.user_id = notes.user_id ORDER BY notes.date_notes DESC;
SELECT `id`, `user_id`, `note`, `date_notes` FROM `notes` ORDER BY `date_notes` DESC;
SELECT `id`, `note`, `date_notes` FROM `notes` WHERE `user_id` = 2;
SELECT `note`, `date_notes` FROM `notes` WHERE `user_id` = 2 AND `id` = 6;
